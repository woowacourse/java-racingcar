package racingcar;

import racingcar.controller.CarController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        var cars = InputView.inputRacingCars();
        var tryCount = InputView.inputTryCount();
        var controller = new CarController(cars, tryCount);
        controller.startGame();
    }
}
