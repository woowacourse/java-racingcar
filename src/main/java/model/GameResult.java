package model;

import java.util.Collections;

public class GameResult {
    private Winners winners;

    public GameResult() {
        winners = new Winners();
    }

    public Winners calculator(Cars cars) {
        Car maxPositionCar = Collections.max(cars.getCars());

        for (Car car : cars.getCars()) {
            addWinners(maxPositionCar, car);
        }

        return winners;
    }

    private void addWinners(Car maxPositionCar, Car car) {
        if (car.compareTo(maxPositionCar) == 0) {
            winners.addWinners(car.getName());
        }
    }
}
