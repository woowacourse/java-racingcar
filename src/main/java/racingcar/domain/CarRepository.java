package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRepository {
    private final List<Car> cars = new ArrayList<>();

    public void saveAll(List<Car> carsToSave) {
        cars.addAll(carsToSave);
    }

    public List<Car> getAllCars() {
        return Collections.unmodifiableList(cars);
    }
}
