package domain;

import utils.NumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Name> names) {
        List<Car> cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public void move(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generate()));
    }

    public List<Car> findWinners() {
        Car maxPositionCar = findMaxPositionCar();
        return findSamePositionCars(maxPositionCar);
    }

    private Car findMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Cars가 비어있습니다."));
    }

    private List<Car> findSamePositionCars(Car maxPositionCar) {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
