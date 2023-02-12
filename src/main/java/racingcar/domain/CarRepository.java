package racingcar.domain;

import racingcar.validator.CarRepositoryValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {
    private static final int MINIMUM_NUMBER_OF_CARS = 2;

    private static final List<Car> cars = new ArrayList<>();

    public static void updateCars(List<Car> newCars) {
        CarRepositoryValidator.validate(newCars);
        cars.addAll(newCars);
    }

    public static List<Car> findAll() {
        return Collections.unmodifiableList(cars);
    }

    public static List<String> findMaxPosition(int maxPosition) {
        return cars.stream().filter(car -> isSamePosition(maxPosition, car))
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private static boolean isSamePosition(int maxPosition, Car car) {
        return car.getPosition() == maxPosition;
    }

    public static void clear() {
        cars.clear();
    }
}
