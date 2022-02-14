package racingcar;

import racingcar.controller.CarController;

public class Application {

    public static void main(String[] args) {
        final CarController controller = new CarController();
        controller.run();
    }
}
