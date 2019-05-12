package racing.controller;

import racing.domain.Race;
import racing.domain.RaceResult;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final Race race;
    private final int numTrials;

    /* 경주 준비 */
    public RacingGame() {
        race = setupRace();
        numTrials = inputNumTrials();
    }

    private Race setupRace() {
        try {
            return new Race(inputCarNames());
        } catch (Exception e) {
            OutputView.printErrMsg(e.getMessage());
            return setupRace();
        }
    }

    private List<String> inputCarNames() {
        try {
            List<String> carNames = InputView.requestNames();
            validateNoDuplication(carNames);
            return carNames;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputCarNames();
        }
    }

    private boolean validateNoDuplication(final List<String> names) {
        List<String> reducedNames = names.stream().distinct().collect(Collectors.toList());
        if (names.size() != reducedNames.size()) throw new IllegalArgumentException("중복된 이름이 존재하면 안됩니다.");
        return true;
    }

    private int inputNumTrials() {
        try {
            OutputView.printTrialRequest();
            return InputView.requestNaturalNumber();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputNumTrials();
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
