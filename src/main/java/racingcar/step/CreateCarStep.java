package racingcar.step;

import racingcar.common.log.Logger;
import racingcar.controller.RacingCarController;
import racingcar.domain.car.Cars;
import racingcar.step.context.GameContext;
import racingcar.view.InputView;

public class CreateCarStep extends RacingCarApplicationStep {

    public CreateCarStep(final RacingCarController controller,
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
        String carNames = InputView.inputCarNames();
        Cars cars = controller.createCars(carNames);
        context.setCars(cars);
        return new InputTotalLapStep(controller, log, context);
    }
}
