package racingcar.step;

import racingcar.common.log.Logger;
import racingcar.controller.RacingCarController;
import racingcar.step.context.GameContext;
import racingcar.view.OutputView;

public class ReadyRaceStep extends RacingCarApplicationStep {

    public ReadyRaceStep(final RacingCarController controller,
                         final Logger log,
                         final GameContext context) {
        super(controller, log, context);
    }

    @Override
    public boolean executable() {
        return true;
    }

    @Override
    protected Step pureExecute() {
        OutputView.printResult();
        return new RunRaceStep(controller, log, context);
    }
}
