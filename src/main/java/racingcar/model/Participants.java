package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class Participants {
    private final List<Car> cars;

    public Participants() {
        this.cars = new ArrayList<>();
    }

    public void participateInRacing(Car car) {
        this.cars.add(car);
    }
}
