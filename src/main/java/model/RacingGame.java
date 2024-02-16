package model;

import java.util.Collections;
import java.util.List;
import util.NumberGenerator;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        validateDuplicateCarNames(cars);
        this.cars = cars;
    }

    private void validateDuplicateCarNames(List<Car> cars) {
        long distinctCount = this.getDistinctCount(cars);
        if (distinctCount != cars.size()) {
            throw new IllegalArgumentException("중복된 이름의 자동차가 존재합니다.");
        }
    }

    private long getDistinctCount(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .distinct()
                .count();
    }

    public void moveCars(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.moveForward(numberGenerator);
        }
    }

    public List<String> findWinners() {
        int maxPosition = this.findMaxPosition();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(Car::getName)
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
