package racingcar.step;

import racingcar.controller.response.MovedResultResponse;
import racingcar.controller.RacingCarController;
import racingcar.domain.Cars;
import racingcar.domain.Lap;
import racingcar.view.OutputView;

public class RunRaceStep extends RacingCarApplicationStep {

    private final Cars cars;
    private final Lap lap;

    public RunRaceStep(final RacingCarController controller,
                       // TODO Context
                       final Cars cars,
                       final Lap lap) {
        super(controller);
        this.cars = cars;
        this.lap = lap;
    }

    @Override
    public boolean executable() {
        return true;
    }

    @Override
    public Step execute() {
        MovedResultResponse result = controller.moveCars(cars, lap);
        OutputView.printState(result);
        return judgeNext(lap);
    }

    private Step judgeNext(final Lap lap) {
        if (lap.hasNext()) {
            return this;
        }
        return new RacingResultStep(controller, cars);
    }
}
