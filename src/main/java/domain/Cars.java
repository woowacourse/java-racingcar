package domain;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Car getCar(int index) {
        return cars.get(index);
    }
}
