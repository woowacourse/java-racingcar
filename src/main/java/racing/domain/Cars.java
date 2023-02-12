package racing.domain;

import racing.RandomNumberGenerator;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> cars) {
        validateCars(cars);
        this.cars = cars.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateCars(List<String> cars) {

        validateDuplicatedName(cars);
        validateEmpty(cars);
    }

    private void validateEmpty(List<String> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("최소 하나 이상의 Car 객체가 존재해야합니다.");
        }
    }

    private void validateDuplicatedName(List<String> cars) {
        Set<String> refined = new HashSet<>(cars);

        if (refined.size() != cars.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public void moveAll(final RandomNumberGenerator generator) {
        for (Car car : cars) {
            int power = generator.generate();
            car.move(power);
        }
    }

    public List<Car> decideWinners() {
        int maxPosition = this.calculateMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int calculateMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Car.MIN_POSITION);
    }

    public List<Car> getUnmodifiableCars() {
        return Collections.unmodifiableList(cars);
    }
}
