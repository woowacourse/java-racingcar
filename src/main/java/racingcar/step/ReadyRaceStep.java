package racingcar.step;

import racingcar.common.log.Logger;
import racingcar.controller.RacingCarController;
import racingcar.domain.Cars;
import racingcar.domain.Lap;
import racingcar.view.OutputView;

public class ReadyRaceStep extends RacingCarApplicationStep {

    private final Cars cars;
    private final Lap lap;

    public ReadyRaceStep(final RacingCarController controller,
                         final Logger log,
                         final Cars cars,
                         final Lap lap) {
        super(controller, log);
        this.cars = cars;
        this.lap = lap;
    }

    @Override
    public boolean executable() {
        return true;
    }

    @Override
    protected Step pureExecute() {
        OutputView.printResult();
        return new RunRaceStep(controller, log, cars, lap);
    }
}
