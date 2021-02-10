package racingCar.domain.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingCar.exception.NoWinnerException;

public class Cars {

    public static final String DELIMITER = ", ";
    public static final String ERROR_MESSAGE_NO_WINNER = "우승자가 존재하지 않습니다.";
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> toList() {
        return new ArrayList<>(cars);
    }

    public void racePerRound() {
        cars.forEach(Car::run);
    }

    private int findMaxMove() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.getMaxValue(maxPosition);
        }
        return maxPosition;
    }

    private String matchSamePosition(final int position) {
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
