package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    public GameController() {
    }

    public void run() {
        RacingGame racingGame = initRacingGame();

        OutputView.printResultMessage();

        while (!racingGame.isEnd()) {
            racingGame.race();
            OutputView.printResult(racingGame.getCars());
        }

        OutputView.printWinners(racingGame.getWinners());
    }

    private RacingGame initRacingGame() {
        try {
            return new RacingGame(InputView.inputCarNames(), InputView.inputTryCount());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return initRacingGame();
        }
    }
}
