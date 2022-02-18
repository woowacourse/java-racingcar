package racingcar;

import racingcar.controller.InputController;
import racingcar.controller.RacingGame;
import racingcar.view.OutputView;

public class Application {
    InputController inputController = new InputController();

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    private void run() {
        String[] carNames = inputController.getUserCarNames();
        int tryCount = inputController.getUserTryCount();
        RacingGame racingGame = new RacingGame(carNames, tryCount);
        try {
            racingGame.play();
        } catch (RuntimeException e) {
            OutputView.printError(e.getMessage());
        }
    }
}
