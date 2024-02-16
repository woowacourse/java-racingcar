package domain;

import java.util.Arrays;
import java.util.List;

public class CarFactory {
    private final List<Car> producedCars;

    private CarFactory(List<Car> producedCars) {
        this.producedCars = producedCars;
    }

    public static CarFactory from(String[] cars) {
        List<Car> producedCars = Arrays.stream(cars)
                .map(Car::from)
                .toList();
        return new CarFactory(producedCars);
    }

    public List<Car> getProducedCars() {
        return producedCars;
    }
}
