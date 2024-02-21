package domain;

import domain.movestrategy.MoveStrategy;

import java.util.Collections;
import java.util.List;

public class RacingGame {
    private RacingGame() {
    }

    public static List<String> getWinnerNames(List<Car> cars) {
        Car maxScoreCar = Collections.max(cars);

        return cars.stream()
                .filter(car -> car.isSame(maxScoreCar))
                .map(Car::getName)
                .toList();
    }

    public static void playOneRound(List<Car> cars, MoveStrategy strategy) {
        for (Car car : cars) {
            if (strategy.willMove()) {
                car.move();
            }
        }
    }


}
