package racingcar.view.formatter.track;

import java.util.stream.Collectors;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.car.WinnerCars;
import racingcar.view.formatter.car.CarsPositionFormatter;

public class TrackStateFormatter {
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";
    private static final String CAR_SEPARATOR = ", ";

    private final CarsPositionFormatter carsPositionFormatter;

    public TrackStateFormatter(CarsPositionFormatter carsPositionFormatter) {
        this.carsPositionFormatter = carsPositionFormatter;
    }

    public String formatCarsPosition(Cars cars) {
        return carsPositionFormatter.formatCarsPosition(cars);
    }

    public String formatWinnerCars(WinnerCars winningCars) {
        String winnerCarsFormat = winningCars.getCars().stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(CAR_SEPARATOR));

        return String.format(WINNER_MESSAGE, winnerCarsFormat);
    }
}
