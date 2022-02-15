package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private List<Car> cars;

    public CarRepository() {
        cars = new ArrayList<>();
    }

    public void addCars(List<Car> targetCars) {
        targetCars.forEach(cars::add);
    }

    public List<Car> findAll() {
        return cars;
    }
}
