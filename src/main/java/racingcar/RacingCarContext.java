package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.car.CarFactory;
import racingcar.model.car.formatter.CarPositionFormatter;
import racingcar.model.car.formatter.CarsPositionFormatter;
import racingcar.model.car.strategy.MovingStrategy;
import racingcar.model.track.formatter.TrackStateFormatter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarContext {
    public static RacingController getRacingControllerInstance(MovingStrategy movingStrategy) {
        CarFactory carFactory = new CarFactory(movingStrategy);

        return new RacingController(InputView.getInstance(), OutputView.getInstance(), carFactory);
    }

    public static TrackStateFormatter getTrackStateFormatter() {
        CarPositionFormatter carFormatter = new CarPositionFormatter();
        CarsPositionFormatter carsPositionFormatter = new CarsPositionFormatter(carFormatter);

        return new TrackStateFormatter(carsPositionFormatter);
    }
}
