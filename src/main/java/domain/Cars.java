package domain;

import java.util.Collections;
import java.util.List;

public class Cars {

    private static final int CAN_NOT_FIND_MAXIMUM = -1;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Car findByName(String name) {
        return cars.stream()
                .filter(car -> car.getName().equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
