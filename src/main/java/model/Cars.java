package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.dto.CarState;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromNames(List<String> names) {
        validateNamesSize(names);
        validateDuplicateName(names);
        List<Car> cars = names.stream()
                .map(name -> Car.fromRandomGenerator(name))
                .toList();
        return new Cars(cars);
    }

    private static void validateNamesSize(List<String> names) {
        if (names.size() < 1) {
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
                .map(car -> car.captureCarState())
                .toList();
    }
}
