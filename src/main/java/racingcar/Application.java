package racingcar;

import racingcar.controller.CarController;

public class Application {
    public static void main(String[] args) {
        var controller = new CarController();
        controller.startGame();
    }
}
