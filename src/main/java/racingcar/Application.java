package racingcar;

import racingcar.controller.InputController;
import racingcar.model.Cars;
import racingcar.model.GameResult;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            final InputController inputController = new InputController();

            final String[] carNames = inputController.getUserCarNames(InputView.scanCarNames());
            final int tryCount = inputController.getUserTryCount(InputView.scanTryCount());

            final RacingGame racingGame = new RacingGame(new Cars(carNames), tryCount);
            OutputView.printResultPrefix();
            List<GameResult> gameResults = racingGame.race();
            OutputView.printResult(gameResults);
            OutputView.printWinner(racingGame.getCars());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
