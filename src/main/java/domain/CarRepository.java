package domain;

import util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {
    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void moveAll(NumberGenerator numberGenerator) {
        for (Car car: cars) {
            car.move(numberGenerator.generate());
        }
    }

    public List<Car> getAll() {
        return new ArrayList<>(cars);
    }

    public void addAll(List<Car> cars) {
        for (Car car : cars) {
            addCar(car);
        }
    }

    public List<Car> findSamePositionCar(Car car) {
        return cars.stream()
                .filter(it -> it.equalsPosition(car))
                .collect(Collectors.toUnmodifiableList());
    }

    public Car findMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow();
    }

}
