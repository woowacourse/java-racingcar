package racingcar;

import racingcar.controller.CarController;

public class Application {
    // psvm 쓰면 한방에 나온다
    public static void main(String[] args) {
        CarController carController = new CarController();
        carController.play();
    }
}
