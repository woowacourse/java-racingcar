package racingcargame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    public final List<Car> cars = new ArrayList<>();

    public RacingCars(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public void go() {
        cars.forEach(car -> car.go(Engine.createRandomEngine()));
    }

    public String printPosition() {
        StringBuilder sb = new StringBuilder();
        for (Car car: cars) {
            sb.append(car.printPosition());
        }
        return sb.toString();
    }
}
