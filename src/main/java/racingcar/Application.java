package racingcar;

import racingcar.controller.InputController;
import racingcar.controller.RaceController;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        final Application application = new Application();
        application.runGame();
    }

    public void runGame() {
        try {
            final InputController inputController = new InputController();
            final RaceController raceController = new RaceController();

            final String[] carNames = inputController.getUserCarNames(InputView.scanCarNames());
            final int tryCount = inputController.getUserTryCount(InputView.scanTryCount());

            final RacingGame racingGame = new RacingGame(new Cars(carNames), tryCount);
            raceController.race(racingGame);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
