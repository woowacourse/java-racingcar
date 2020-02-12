package racingcargame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final static List<Car> cars = new ArrayList<>();

    public RacingCars(List<Car> cars) {
        cars.addAll(cars);
    }

    public void go() {
        cars.forEach(car -> car.go(Engine.getRandom()));
    }
}
