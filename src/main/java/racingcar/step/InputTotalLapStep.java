package racingcar.step;

import racingcar.controller.RacingCarController;
import racingcar.domain.Cars;
import racingcar.domain.Lap;
import racingcar.view.InputView;

public class InputTotalLapStep extends RacingCarApplicationStep {

    private final Cars cars;
    
    public InputTotalLapStep(final RacingCarController controller, final Cars cars) {
        super(controller);
        this.cars = cars;
    }

    @Override
    public boolean executable() {
        return true;
    }

    @Override
    public Step execute() {
        int totalLap = InputView.inputTotalLap();
        Lap lap = controller.confirmTotalLap(totalLap);
        return new ReadyRaceStep(controller, cars, lap);
    }
}
