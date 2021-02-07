package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private static final List<Car> cars = new ArrayList<>();

    private Cars() {
    }

    public static void setCarsByName(List<String> names) {
        validateNonDuplicatedNames(names);
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public static List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public static int getMaxPositionByCars() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }

    private static void validateNonDuplicatedNames(List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름입니다.");
        }
    }
}
