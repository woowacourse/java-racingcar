package racingcar.step;

import racingcar.common.log.Logger;
import racingcar.controller.RacingCarController;
import racingcar.domain.game.Lap;
import racingcar.step.context.GameContext;
import racingcar.view.InputView;

public class InputTotalLapStep extends RacingCarApplicationStep {

    public InputTotalLapStep(final RacingCarController controller,
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
        int totalLap = InputView.inputTotalLap();
        Lap lap = controller.confirmTotalLap(totalLap);
        context.setLap(lap);
        return new ReadyRaceStep(controller, log, context);
    }
}
