package domain;

import java.util.Collections;
import java.util.List;

public class RacingGame {

    public static List<String> getWinnerNames(List<Car> cars) {

        Collections.sort(cars);
        Car maxScoreCar = cars.get(0);

        return cars.stream()
                .filter(car -> car.compareTo(maxScoreCar) == 0)
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
