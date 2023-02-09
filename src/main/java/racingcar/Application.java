package racingcar;

import racingcar.controller.CarController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarController carController = new CarController();
        carController.run();
    }
}
