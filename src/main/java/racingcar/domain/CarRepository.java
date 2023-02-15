package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {
    private static final int MINIMUM_NUMBER_OF_CARS = 2;
    private static final List<Car> cars = new ArrayList<>();
    
    private CarRepository() { }

    public static void updateCars(List<Car> newCars) {
        validate(newCars);
        cars.addAll(newCars);
    }
    
    private static void validate(List<Car> newCars) {
        validateLessThanMinimumNumberOfCars(newCars);
        validateDuplicatedCarNames(newCars);
    }
    
    private static void validateDuplicatedCarNames(List<Car> newCars) {
        if (numberOfDeleteDuplicatedCars(newCars) != newCars.size()) {
            throw new IllegalArgumentException("차 이름은 중복될 수 없습니다.");
        }
    }
    
    private static int numberOfDeleteDuplicatedCars(List<Car> newCars) {
        return (int) newCars.stream()
                .map(Car::getName)
                .distinct()
                .count();
    }
    
    private static void validateLessThanMinimumNumberOfCars(List<Car> newCars) {
        if (newCars.size() < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("차가 두 대 이상이어야 합니다.");
        }
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
