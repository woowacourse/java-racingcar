package racing;

import racing.controller.RacingGame;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingApplication {

    public static void main(String[] args) {
        RacingGame racingGame = createRacingGame();

        while (!racingGame.isEnd()) {
            OutputView.printRace(racingGame.race());
        }

        OutputView.printResult(racingGame.getResult());
    }

    /* RacingGame 생성시 발생할 수 있는 예외를 처리하기 위한 메소드*/
    private static RacingGame createRacingGame() {
        try {
            return new RacingGame(InputView.inputNames(), InputView.inputNumTrials());
        } catch (Exception e) {
            OutputView.printErrMsg(e.getMessage());
            return createRacingGame();
        }
    }
}
