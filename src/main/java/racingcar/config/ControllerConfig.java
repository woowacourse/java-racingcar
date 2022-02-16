package racingcar.config;

import racingcar.controller.RacingCarController;

public class ControllerConfig {

    public static RacingCarController getRacingCarController() {
        return new RacingCarController(ViewConfig.getInputView(), ViewConfig.getOutputView());
    }
}
