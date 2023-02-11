package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.car.CarFactory;
import racingcar.model.car.strategy.MovingStrategy;
import racingcar.model.car.strategy.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarContext {
    private static RacingController racingController;

    public static RacingController racingController() {
        if (racingController == null) {
            MovingStrategy randomMovingStrategy = new RandomMovingStrategy();
            CarFactory carFactory = new CarFactory(randomMovingStrategy);

            racingController = new RacingController(InputView.getInstance(), OutputView.getInstance(), carFactory);
        }

        return racingController;
    }
}
