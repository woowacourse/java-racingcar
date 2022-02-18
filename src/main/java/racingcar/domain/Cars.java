package racingcar.domain;

import static racingcar.constants.output.ErrorOutputMessages.ERROR_CARS_EMPTY;

import java.util.Collections;
import racingcar.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public List<Car> findAllCars() {
        return Collections.unmodifiableList(cars);
    }

    public void add(Car car) {
        cars.add(car);
    }

    public void race() {
        for (Car car : cars) {
            car.goOrNot(RandomUtils.generateNumber());
        }
    }

    public List<Car> getWinners() {
        Car carMaxPosition = getCarMaxPosition();

        return cars.stream()
                .filter(car -> car.isSamePosition(carMaxPosition))
                .collect(Collectors.toList());
    }

    private Car getCarMaxPosition() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(ERROR_CARS_EMPTY));
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
