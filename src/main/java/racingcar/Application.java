package racingcar;

import racingcar.controller.CarController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final var cars = InputView.inputRacingCars();
        final var tryCount = InputView.inputTryCount();
        final var controller = new CarController(cars, tryCount);
        controller.startGame();
        OutputView.printGameResult(controller.getGameResult());
    }
}
