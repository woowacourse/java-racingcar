package racingcar.domain;

import racingcar.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final List<Car> cars = new ArrayList<>();

    public List<Car> findAllCars() {
        return cars;
    }

    public void add(Car car) {
        cars.add(car);
    }

    public void clear() {
        cars.clear();
    }

    public void race() {
        for (Car car : cars) {
            car.goOrNot(RandomUtils.generateNumber());
        }
    }
}
