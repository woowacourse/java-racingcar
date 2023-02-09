package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static constant.Constants.MINIMUM_NUMBER_OF_CARS_EXCEPTION;

public class CarRepository {
    private static final int MINIMUM_NUMBER_OF_CARS = 2;

    private static final List<Car> cars = new ArrayList<>();

    public static void updateCars(List<Car> newCars) {
        if (newCars.size() < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException(MINIMUM_NUMBER_OF_CARS_EXCEPTION);
        }
        cars.addAll(newCars);
    }

    public static List<Car> findAll() {
        return Collections.unmodifiableList(cars);
    }

    public static List<String> findSamePositionWith(int maxPosition) {
        return cars.stream().filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public static void clear() {
        cars.clear();
    }
}
