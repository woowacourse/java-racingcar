package model;

import java.util.Collections;

public class GameResult {
    private Winners winners = new Winners();

    public GameResult(Cars cars) {
        Car maxPositionCar = Collections.max(cars.getCars());

        for (Car car : cars.getCars()) {
            addWinners(maxPositionCar, car);
        }
    }

    private void addWinners(Car maxPositionCar, Car car) {
        if (car.compareTo(maxPositionCar) == 0) {
            winners.addWinners(car.getName());
        }
    }

    public Winners getWinners() {
        return winners;
    }
}
