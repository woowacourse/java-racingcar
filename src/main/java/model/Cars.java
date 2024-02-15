package model;

import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        verifyDuplicateCarNames(cars);
        this.cars = cars;
    }

    private void verifyDuplicateCarNames(List<Car> cars) {
        long distinctCount = cars.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (distinctCount != cars.size()) {
            throw new IllegalArgumentException("중복된 이름의 자동차가 존재합니다.");
        }
    }

    public int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
