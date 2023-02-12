package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.car.CarFactory;
import racingcar.model.car.formatter.CarPositionFormatter;
import racingcar.model.car.formatter.CarsPositionFormatter;
import racingcar.model.car.strategy.MovingStrategy;
import racingcar.model.car.strategy.RandomMovingStrategy;
import racingcar.model.track.formatter.TrackStateFormatter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarContext {
    private static RacingController racingController;
    private static TrackStateFormatter trackStateFormatter;

    public static RacingController randomRacingController() {
        if (racingController == null) {
            MovingStrategy randomMovingStrategy = new RandomMovingStrategy();
            CarFactory carFactory = new CarFactory(randomMovingStrategy);

            racingController = new RacingController(InputView.getInstance(), OutputView.getInstance(), carFactory);
        }

        return racingController;
    }

    public static TrackStateFormatter trackStateFormatter() {
        if (trackStateFormatter == null) {
            CarPositionFormatter carFormatter = new CarPositionFormatter();
            CarsPositionFormatter carsPositionFormatter = new CarsPositionFormatter(carFormatter);
            trackStateFormatter = new TrackStateFormatter(carsPositionFormatter);
        }

        return trackStateFormatter;
    }
}
