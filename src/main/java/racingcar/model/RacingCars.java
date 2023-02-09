package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {

    private List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {
        return new ArrayList<>();
    }

    private Car getMaxPositionCar() {
        return new Car("", 0);
    }

    private List<Car> getMaxPositionCars(Car maxPositionCar) {
        return new ArrayList<>();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
