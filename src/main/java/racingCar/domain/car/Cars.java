package racingCar.domain.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingCar.exception.InvalidCarNameException;
import racingCar.exception.NoWinnerException;

public class Cars {

    public static final String DELIMITER = ", ";
    public static final String ERROR_MESSAGE_CAR_NAMES_COUNT = "자동차 이름은 1개 이상이어야 합니다.";
    public static final String ERROR_MESSAGE_NO_WINNER = "우승자가 존재하지 않습니다.";
    public static final int MIN_NUM_OF_CARS = 2;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        if (cars.size() < MIN_NUM_OF_CARS) {
            throw new InvalidCarNameException(ERROR_MESSAGE_CAR_NAMES_COUNT);
        }
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> toList() {
        return new ArrayList<>(cars);
    }

    public void racePerRound() {
        cars.forEach(Car::run);
    }

    private Position findMaxMove() {
        return cars.stream()
            .map(Car::getPosition)
            .reduce(Position::compareTo)
            .orElseThrow(() -> new NoWinnerException(ERROR_MESSAGE_NO_WINNER));
    }

    private String matchSamePosition(final Position position) {
        return cars
            .stream()
            .filter(car -> car.isOn(position))
            .map(Car::getName)
            .collect(Collectors.joining(DELIMITER));
    }

    public String findWinners() {
        String winners = matchSamePosition(findMaxMove());
        if (winners.isEmpty()) {
            throw new NoWinnerException(ERROR_MESSAGE_NO_WINNER);
        }
        return winners;
    }

}
