package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;

public class AppConfig {

    public static RacingCarController getRacingCarController() {
        return new RacingCarController(ViewConfig.getInputView(), ViewConfig.getOutputView(),
            getRacingCarService());
    }

    private static RacingCarService getRacingCarService() {
        return new RacingCarService();
    }
}
