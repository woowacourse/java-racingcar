package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        RacingGame racingGame = initRacingGame();

        outputView.printResultMessage();

        while (!racingGame.isEnd()) {
            racingGame.race();
            outputView.printResult(racingGame.getCars());
        }

        outputView.printWinners(racingGame.getWinners());
    }

    private RacingGame initRacingGame() {
        try {
            return new RacingGame(inputView.inputCarNames(), inputView.inputTryCount());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return initRacingGame();
        }
    }
}
