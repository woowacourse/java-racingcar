package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import utils.constants.ErrorMessages;
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
        Car maxValueCar = calculateMaxPosition();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxValueCar))
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private Car calculateMaxPosition() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessages.NO_EXISTED_MAX_VALUE_CAR.getMessage()));
    }

    public List<String> retrieveMoveResults() {
        return cars.stream()
                .map(Car::retrieveMoveResults)
                .collect(Collectors.toUnmodifiableList());
    }
}
