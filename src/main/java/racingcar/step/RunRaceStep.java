package racingcar.step;

import racingcar.common.log.Logger;
import racingcar.controller.RacingCarController;
import racingcar.controller.response.MovedResultResponse;
import racingcar.step.context.GameContext;
import racingcar.view.OutputView;

public class RunRaceStep extends RacingCarApplicationStep {

    public RunRaceStep(final RacingCarController controller,
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
        MovedResultResponse result = controller.moveCars(context.getCars(), context.getLap());
        OutputView.printState(result);
        return judgeNext();
    }

    private Step judgeNext() {
        if (context.getLap().hasNext()) {
            return this;
        }
        return new RacingResultStep(controller, log, context);
    }
}
