package racingcar.model.track.formatter;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.car.formatter.CarsPositionFormatter;

public class TrackStateFormatter {
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";
    private static final String CAR_SEPARATOR = ", ";

    private final CarsPositionFormatter carsPositionFormatter;

    public TrackStateFormatter(CarsPositionFormatter carsPositionFormatter) {
        this.carsPositionFormatter = carsPositionFormatter;
    }

    public String carsPositionFormat(Cars cars) {
        return carsPositionFormatter.format(cars);
    }

    public String winnerCarsFormat(List<Car> winningCars) {
        String winnerCarsFormat = winningCars.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(CAR_SEPARATOR));

        return String.format(WINNER_MESSAGE, winnerCarsFormat);
    }
}
