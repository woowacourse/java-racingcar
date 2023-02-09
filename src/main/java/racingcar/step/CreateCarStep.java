package racingcar.step;

import racingcar.controller.RacingCarController;
import racingcar.domain.Cars;
import racingcar.view.InputView;

public class CreateCarStep extends RacingCarApplicationStep {

    public CreateCarStep(final RacingCarController controller) {
        super(controller);
    }

    @Override
    public boolean executable() {
        return true;
    }

    @Override
    public Step execute() {
        String carNames = InputView.inputCarNames();
        Cars cars = controller.createCars(carNames);
        return new InputTotalLapStep(controller, cars);
    }
}
