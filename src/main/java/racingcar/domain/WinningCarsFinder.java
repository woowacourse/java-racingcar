package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningCarsFinder {
    public static List<Car> findWinningCars(List<Car> cars) {
        List<Car> winningCars = new ArrayList<>();
        winningCars.add(cars.get(0));

        for (int i = 1; i < cars.size(); i++) {
            addWinningCars(winningCars,cars.get(i));
        }
        return winningCars;
    }

    private static void addWinningCars(List<Car> winningCars, Car nextCar) {
        int result = nextCar.comparePosition(winningCars.get(0));

        if(result == 1) {
            return;
        }
        if (result == -1) {
            winningCars.clear();
        }
        winningCars.add(nextCar);
    }
}
