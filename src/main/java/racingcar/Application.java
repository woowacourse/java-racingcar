package racingcar;

import racingcar.controller.CarController;

public class Application {
    public static void main(final String... args) {
        CarController carController = new CarController();
        carController.play();
    }
}
