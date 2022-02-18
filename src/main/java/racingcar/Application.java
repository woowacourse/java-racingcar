package racingcar;

import racingcar.controller.InputController;
import racingcar.controller.RaceController;
import racingcar.model.RacingGame;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.runGame();
    }

    public void runGame() {
        try {
            InputController inputController = new InputController();
            RaceController raceController = new RaceController();

            String[] carNames = inputController.getUserCarNames(InputView.scanCarNames());
            int tryCount = inputController.getUserTryCount(InputView.scanTryCount());

            RacingGame racingGame = new RacingGame(raceController.insertCarFromCarNames(carNames), tryCount);
            raceController.race(racingGame);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
