package domain;

import utils.NumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generate()));
    }

    public List<Car> findWinners() {
        Car maxPositionCar = findMaxPositionCar();
        return findSamePositionCars(maxPositionCar);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private List<Car> findSamePositionCars(Car maxPositionCar) {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .collect(Collectors.toList());
    }

    private Car findMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Cars가 비어있습니다."));
    }
}
