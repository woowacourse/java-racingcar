package racingcar.model.car;

import racingcar.exception.DuplicateCarNamesException;
import racingcar.exception.NotExistCarsException;
import racingcar.model.car.strategy.MovingStrategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int NOT_EXIST_CARS = 0;
    private static final String SEPARATOR = ",";

    private final List<Car> cars;

    public Cars(final String carNames, final MovingStrategy movingStrategy) {
        validate(carNames);

        this.cars = Arrays.stream(carNames.split(SEPARATOR))
                .map(carName -> new Car(carName, movingStrategy))
                .collect(Collectors.toList());
    }

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    private void validate(final String carNames) {
        String[] splitCarNames = carNames.split(SEPARATOR);

        validateNotExistCar(splitCarNames);
        validateDuplicateCarNames(splitCarNames);
    }

    private void validateNotExistCar(final String[] splitCarNames) {
        if (splitCarNames.length == NOT_EXIST_CARS) {
            throw new NotExistCarsException();
        }
    }

    private void validateDuplicateCarNames(final String[] splitCarNames) {
        int carNamesCount = splitCarNames.length;
        int distinctCarNamesCount = new HashSet<>(Arrays.asList(splitCarNames)).size();

        if (carNamesCount != distinctCarNamesCount) {
            throw new DuplicateCarNamesException();
        }
    }

    public void moveCars() {
        cars.stream()
                .filter(Car::movable)
                .forEach(Car::moveForward);
    }

    public List<Car> getCarsCurrentInfo() {
        return cars.stream().collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getWinnerCars() {
        Integer maxPosition = Collections.max(cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()));

        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toUnmodifiableList());
    }
}
