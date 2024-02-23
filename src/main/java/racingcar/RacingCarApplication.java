package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.Controller;

public class RacingCarApplication {

    public static void main(String[] args) {
        Controller controller = AppConfig.config();
        controller.run();
    }
}
