package racingcar.step;

import racingcar.common.log.Logger;
import racingcar.controller.RacingCarController;
import racingcar.step.context.GameContext;
import racingcar.view.OutputView;

import java.util.List;

public class RacingResultStep extends RacingCarApplicationStep {

    public RacingResultStep(final RacingCarController controller,
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
        List<String> winners = controller.winners(context.getCars());
        OutputView.printWinners(winners);
        return new Exit();
    }
}
