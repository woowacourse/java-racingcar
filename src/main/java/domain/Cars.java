package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import utils.numberGenerator.NumberGenerator;

public class Cars {
    private final List<Car> cars = new ArrayList<>();
    private final NumberGenerator numberGenerator;

    public Cars(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void add(Car car) {
        cars.add(car);
    }

    public void move() {
        cars.forEach((car) -> car.move(numberGenerator.generateNumber()));
    }

    public List<String> calculateWinners() {
        Long maxValue = calculateMaxPosition();
        return cars.stream()
                .filter((car) -> Objects.equals(car.getPosition(), maxValue))
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private Long calculateMaxPosition() {
        return Collections.max(cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toUnmodifiableList()));
    }

    public List<String> retrieveMoveResults() {
        return cars.stream()
                .map(Car::retrieveMoveResults)
                .collect(Collectors.toUnmodifiableList());
    }
}
