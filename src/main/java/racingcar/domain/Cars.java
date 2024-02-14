package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(final Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
