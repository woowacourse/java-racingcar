package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinnerCars {
    private static List<Car> winnerCars;

    public static void determineWinners(List<Car> cars) {
        winnerCars = new ArrayList<>();

        Collections.sort(cars);
        Car maxPositionCar = cars.get(0);

        for (Car car : cars) {
            if (!maxPositionCar.isEqualPosition(car)) {
                break;
            }

            winnerCars.add(car);
        }
    }

    public static List<Car> getWinnerCars() {
        return winnerCars;
    }
}
