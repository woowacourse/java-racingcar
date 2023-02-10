package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class CarRepository {
    private final List<Car> cars = new ArrayList<>();

    public void saveAll(List<Car> cars) {
        this.cars.addAll(cars);
    }

    // List.copyOf와 Collections.unmodifiableList의 차이?
    public List<Car> findAll() {
        return List.copyOf(cars);
    }
}
