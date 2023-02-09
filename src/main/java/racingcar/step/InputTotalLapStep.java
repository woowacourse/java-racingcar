package racingcar.step;

import racingcar.common.log.Logger;
import racingcar.controller.RacingCarController;
import racingcar.domain.Cars;
import racingcar.domain.Lap;
import racingcar.view.InputView;

public class InputTotalLapStep extends RacingCarApplicationStep {

    private final Cars cars;
    
    public InputTotalLapStep(final RacingCarController controller,
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
        int totalLap = InputView.inputTotalLap();
        Lap lap = controller.confirmTotalLap(totalLap);
        return new ReadyRaceStep(controller, log, cars, lap);
    }
}
