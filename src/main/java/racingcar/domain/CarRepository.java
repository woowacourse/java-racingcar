package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRepository {

    private static final List<Car> cars = new ArrayList<>();

    public List<Car> findAllCars() {
        return Collections.unmodifiableList(cars);
    }

    public void add(Car car) {
        cars.add(car);
    }

    public void clear() {
        cars.clear();
    }
}
