package racingcar;

import racingcar.controller.RacingController;
import racingcar.manager.RacingManager;

public class Application {
    public static void main(String[] args) {
        RacingManager manager = new RacingManager();
        RacingController racingController = manager.createRacingController();
        racingController.start();
    }
}
