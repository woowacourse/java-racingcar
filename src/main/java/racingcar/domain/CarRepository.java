package racingcar.domain;

import java.util.List;

public class CarRepository {
    private final List<Car> cars;

    public CarRepository(List<Car> cars) {
        this.cars = cars;
    }
}
