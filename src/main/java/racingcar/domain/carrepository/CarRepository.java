package racingcar.domain.carrepository;

import racingcar.domain.car.Car;

import java.util.List;

public class CarRepository {

    private final List<Car> repository;

    public CarRepository(List<Car> repository) {
        this.repository = repository;
    }
}
