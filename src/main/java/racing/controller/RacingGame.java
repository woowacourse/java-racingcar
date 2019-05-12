package racing.controller;

import racing.domain.Race;
import racing.domain.RaceResult;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingGame {
    private final Race race;
    private final int numTrials;

    /* 경주 준비 */
    public RacingGame() {
        race = setupRace();
        numTrials = InputView.inputNumTrials();
    }

    /* Car 생성시 발생할 수 있는 예외를 처리하기 위한 메소드*/
    private Race setupRace() {
        try {
            return new Race(InputView.inputNames());
        } catch (Exception e) {
            OutputView.printErrMsg(e.getMessage());
            return setupRace();
        }
    }

    /* 경주 시작 */
    public void startGame() {
        repeatRace(numTrials);
        OutputView.printRace(race);
    }

    /* 경주 진행 */
    private void repeatRace(int numTrials) {
        OutputView.printResultMessage();
        for (int i = 0; i < numTrials; i++) {
            race.progressRace();
            OutputView.printRace(race);
            OutputView.printNewLine();
        }
    }

    /* 경주 종료 */
    public void endGame() {
        RaceResult result = race.getResult();
        OutputView.printResult(result);
    }
}
