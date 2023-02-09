package racingcar.step;

import racingcar.controller.RacingCarController;

public class Exit extends RacingCarApplicationStep {

    protected Exit(RacingCarController controller) {
        super(controller);
    }

    @Override
    public boolean executable() {
        return false;
    }

    @Override
    public Step execute() {
        System.out.println("Exit.execute");
        return null;
    }
}
