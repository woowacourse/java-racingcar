package model.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public void addCar(Car car) {
        cars.add(car);
    }
}
