package racingcar;

import racingcar.controller.InputController;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        try {
            final InputController inputController = new InputController();

            final String[] carNames = inputController.getUserCarNames(InputView.scanCarNames());
            final int tryCount = inputController.getUserTryCount(InputView.scanTryCount());

            final RacingGame racingGame = new RacingGame(new Cars(carNames), tryCount);
            OutputView.printResultPrefix();
            racingGame.race();
            OutputView.printWinner(racingGame.getCars());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
