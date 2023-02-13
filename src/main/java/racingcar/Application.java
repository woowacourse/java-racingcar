package racingcar;

import racingcar.controller.RacingCarController;

public class Application {

    public static void main(String[] args) {
        CarRandomNumberGenerator carRandomNumberGenerator = new CarRandomNumberGenerator();
        RacingCarController racingCarController = new RacingCarController(carRandomNumberGenerator);
        racingCarController.run();
    }
}
