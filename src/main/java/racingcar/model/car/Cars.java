package racingcar.model.car;

import racingcar.exception.DuplicateCarNamesException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String CAR_SEPARATOR = ", ";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);

        this.cars = cars;
    }

    private void validate(List<Car> cars) {
        int carNamesCount = cars.size();
        int distinctCarNamesCount = cars.stream().map(Car::getCarName).collect(Collectors.toSet()).size();

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

    public Cars getWinnerCars() {
        Integer maxPosition = Collections.max(cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()));

        return new Cars(cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList()));
    }

    public String getCarsWinnerFormat() {
        return cars.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(CAR_SEPARATOR));
    }
}
