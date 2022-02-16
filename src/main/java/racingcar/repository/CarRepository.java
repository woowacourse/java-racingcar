package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private final List<Car> cars;

    public CarRepository() {
        cars = new ArrayList<>();
    }

    public void addCars(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public List<Car> findAll() {
        return cars;
    }
}
