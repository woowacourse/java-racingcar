package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.dto.CarState;

public class Cars {
    private static final int MIN_CAR_NAMES_SIZE = 1;
    private static final int DEFAULT_MAX_FORWARD_COUNT = 0;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromNames(List<String> names) {
        validate(names);
        List<Car> cars = names.stream()
                .map(name -> Car.fromRandomGenerator(name))
                .toList();
        return new Cars(cars);
    }

    private static void validate(List<String> names) {
        validateNamesSize(names);
        validateDuplicateName(names);
    }

    private static void validateNamesSize(List<String> names) {
        if (names.size() < MIN_CAR_NAMES_SIZE) {
            throw new IllegalArgumentException("자동차는 한 대 이상어야아 한다");
        }
    }

    private static void validateDuplicateName(List<String> names) {
        Set<String> nonDuplicateNames = new HashSet<>(names);
        if (nonDuplicateNames.size() != names.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없다");
        }
    }

    public void tryForward() {
        for (Car car : cars) {
            car.tryForward();
        }
    }

    public List<CarState> captureCarStates() {
        return cars.stream()
                .map(CarState::create)
                .toList();
    }

    public List<String> findAllNameByForwardCount(int targetForwardCount) {
        return cars.stream()
                .filter(car -> car.hasForwardCount(targetForwardCount))
                .map(Car::getName)
                .toList();
    }

    public int calculateMaxForwardCount() {
        return cars.stream()
                .mapToInt(Car::getForwardCount)
                .max()
                .orElse(DEFAULT_MAX_FORWARD_COUNT);
    }
}
