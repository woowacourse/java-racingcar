package racingcar.domain.car;

import racingcar.exception.EmptyCarException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateEmptyCarList(cars);
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    private void validateEmptyCarList(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new EmptyCarException();
        }
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(cars);
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<CarName> getWinnersName() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}

