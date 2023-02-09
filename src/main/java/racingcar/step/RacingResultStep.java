package racingcar.step;

import racingcar.controller.RacingCarController;
import racingcar.domain.Cars;
import racingcar.view.OutputView;

import java.util.List;

public class RacingResultStep extends RacingCarApplicationStep {
    private final Cars cars;

    public RacingResultStep(final RacingCarController controller, final Cars cars) {
        super(controller);
        this.cars = cars;
    }

    @Override
    public boolean executable() {
        return true;
    }

    @Override
    public Step execute() {
        List<String> winners = controller.winners(cars);
        OutputView.printWinners(winners);
        return new Exit(controller);
    }
}
