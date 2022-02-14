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
        RacingGame racingGame = new RacingGame(createCarNames(), createTryCount());

        outputView.printResultMessage();

        for (int i = 0; i < racingGame.getTryCount(); i++) {
            racingGame.race();
            outputView.printResult(racingGame.getCars());
        }

        outputView.printWinners(racingGame.getWinners());
    }

    public String[] createCarNames() {
        try {
            return inputView.inputCarNames();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createCarNames();
        }
    }

    public int createTryCount() {
        try {
            return inputView.inputTryCount();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createTryCount();
        }
    }
}
