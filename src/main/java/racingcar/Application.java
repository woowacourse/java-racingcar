package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.RacingCarController;

public class Application {

    public static void main(String[] args) {
        RacingCarController racingCarController = AppConfig.getRacingCarController();
        racingCarController.run();
    }
}
