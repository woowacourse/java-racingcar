package racingcar.step;

import racingcar.common.log.Logger;
import racingcar.controller.RacingCarController;
import racingcar.domain.Cars;
import racingcar.view.OutputView;

import java.util.List;

public class RacingResultStep extends RacingCarApplicationStep {
    private final Cars cars;

    public RacingResultStep(final RacingCarController controller,
                            final Logger log,
                            final Cars cars) {
        super(controller, log);
        this.cars = cars;
    }

    @Override
    public boolean executable() {
        return true;
    }

    @Override
    protected Step pureExecute() {
        List<String> winners = controller.winners(cars);
        OutputView.printWinners(winners);
        return new Exit();
    }
}
