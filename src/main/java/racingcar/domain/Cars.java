package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Cars {
    private static List<Car> cars = new ArrayList<>();

    private Cars() {
    }

    public static void assignCars(final List<String> names) {
        validateNonDuplicatedNames(names);
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public static List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public static Car getMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(IllegalStateException::new);
    }

    private static void validateNonDuplicatedNames(final List<String> names) {
        if (new HashSet<>(names).size() != names.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름입니다.");
        }
    }
}
