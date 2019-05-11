package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinnerCars {
    public static List<Car> determineWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>();

        Collections.sort(cars);
        Car maxCar = cars.get(0);

        for (Car car : cars) {
            if (!maxCar.isEqualPosition(car)) {
                break;
            }

            winners.add(car);
        }

        return winners;
    }
}
