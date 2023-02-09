package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.service.CarService;

public class Application {
    public static void main(String[] args) {
        RacingcarController racingcarController = new RacingcarController(new CarService());
        racingcarController.start();
        racingcarController.run();
        racingcarController.finish();
    }
}