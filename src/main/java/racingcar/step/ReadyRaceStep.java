package racingcar.step;

import racingcar.controller.RacingCarController;
import racingcar.domain.Cars;
import racingcar.domain.Lap;
import racingcar.view.OutputView;

public class ReadyRaceStep extends RacingCarApplicationStep {

    private final Cars cars;
    private final Lap lap;

    public ReadyRaceStep(final RacingCarController controller,
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
        OutputView.printResult();
        return new RunRaceStep(controller, cars, lap);
    }
}
