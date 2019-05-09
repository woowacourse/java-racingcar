package model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    List<Car> cars;

    RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    void run() {
        Racing racing = new Racing();
        for (Car car : cars) {
            racing.move(car);
        }
    }
}
