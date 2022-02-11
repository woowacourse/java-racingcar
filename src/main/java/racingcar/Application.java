package racingcar;

import racingcar.config.ControllerConfig;
import racingcar.controller.RacingCarController;

public class Application {

    public static void main(String[] args) {
        RacingCarController racingCarController = ControllerConfig.getRacingCarController();
        racingCarController.run();
    }
}
