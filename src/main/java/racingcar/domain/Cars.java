package racingcar.domain;

import java.util.*;

public class Cars {
    public static final int MIN_CARS_SIZE = 1;
    public static final int MAX_CARS_SIZE = 10;
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateNotDuplicate(cars);
        validateCarsSize(cars);
        this.cars = Collections.unmodifiableList(cars);
    }

    private void validateNotDuplicate(final List<Car> cars) {
        Set<Car> uniqueCars = new HashSet<>(cars);
        if (cars.size() != uniqueCars.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    private void validateCarsSize(final List<Car> cars) {
        if (cars.size() < MIN_CARS_SIZE || cars.size() > MAX_CARS_SIZE) {
            throw new IllegalArgumentException("자동차의 수가 범위 밖입니다.");
        }
    }
}
