package racingcar;

import racingcar.controller.CarController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        final var cars = InputView.inputRacingCars();
        final var tryCount = InputView.inputTryCount();
        final var controller = new CarController(cars, tryCount);
        controller.startGame();
    }
}
