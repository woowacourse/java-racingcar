package racingcar.domain.car;

import racingcar.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void goForwardAllCarsRandomly() {
        for (Car car : cars) {
            goForwardOrStopRandomly(car);
        }
    }

    private void goForwardOrStopRandomly(final Car car) {
        int randomNumber = RandomUtils
                .generateRandomNumber(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);

        if (GoForwardOrStop.isGoForward(randomNumber)) {
            car.goForward();
        }
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public List<String> getWinnerNames() {
        return getWinners().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getWinners() {
        final Position maxPosition = new Position(getMaxPosition());

        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(RuntimeException::new);
    }
}
