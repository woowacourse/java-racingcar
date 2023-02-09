package racingcar.step;

import racingcar.common.log.Logger;
import racingcar.controller.RacingCarController;
import racingcar.domain.Cars;
import racingcar.view.InputView;

public class CreateCarStep extends RacingCarApplicationStep {

    public CreateCarStep(final RacingCarController controller,
                         final Logger log) {
        super(controller, log);
    }

    @Override
    public boolean executable() {
        return true;
    }

    @Override
    protected Step pureExecute() {
        String carNames = InputView.inputCarNames();
        Cars cars = controller.createCars(carNames);
        return new InputTotalLapStep(controller, log, cars);
    }
}
