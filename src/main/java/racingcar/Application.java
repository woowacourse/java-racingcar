package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final var cars = InputView.inputRacingCars();
        final var tryCount = InputView.inputTryCount();
        final var racingGame = new RacingGame(cars, tryCount);
        racingGame.startGame();
        OutputView.printGameResult(racingGame.getGameResult());
    }
}
