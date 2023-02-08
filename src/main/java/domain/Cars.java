package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Car findByName(String name) {
        return cars.stream()
                .filter(car -> car.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
