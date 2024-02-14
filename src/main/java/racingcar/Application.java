package racingcar;

import racingcar.controller.CarController;
import racingcar.model.Car;

public class Application {
    public static void main(String[] args) {
        var controller = new CarController();
        controller.startGame();
    }
}
