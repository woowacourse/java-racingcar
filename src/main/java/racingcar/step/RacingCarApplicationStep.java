package racingcar.step;

import racingcar.controller.RacingCarController;

public abstract class RacingCarApplicationStep implements Step {

    protected final RacingCarController controller;

    protected RacingCarApplicationStep(final RacingCarController controller) {
        this.controller = controller;
    }
}
