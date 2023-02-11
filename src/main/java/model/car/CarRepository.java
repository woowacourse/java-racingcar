package model.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRepository {
    private final List<Car> cars = new ArrayList<>();

    public CarRepository() {
    }

    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public void addCars(Car car) {
        cars.add(car);
    }
}
