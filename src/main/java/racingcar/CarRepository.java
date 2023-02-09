package racingcar;

import validator.CarRepositoryValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static constant.Constants.MINIMUM_NUMBER_OF_CARS_EXCEPTION;

public class CarRepository {
    private static final int MINIMUM_NUMBER_OF_CARS = 2;

    private static final List<Car> cars = new ArrayList<>();

    public static void updateCars(List<Car> newCars) {
<<<<<<< HEAD
        CarRepositoryValidator.validate(newCars);
=======
        if (newCars.size() < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException(MINIMUM_NUMBER_OF_CARS_EXCEPTION);
        }
>>>>>>> 626b5ef (feat: 자동차 한 대 이하로 입력한 경우 예외 처리)
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

    public static void clear() {
        cars.clear();
    }
}
