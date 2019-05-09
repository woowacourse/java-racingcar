package model;

import java.util.List;

public class RacingGame {
    public void run(List<Car> cars) {
        Racing racing = new Racing();
        for (Car car : cars) {
            racing.move(car);
        }
    }
}
