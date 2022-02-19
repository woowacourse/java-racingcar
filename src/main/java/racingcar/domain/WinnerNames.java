package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinnerNames {
    private final List<String> winnerNames;

    public WinnerNames() {
        winnerNames = new ArrayList<>();
    }

    public List<String> findWinners(List<Car> cars) {
        return getWinnerNamesWithFirstCar(findFastestCar(cars), cars);
    }

    private Car findFastestCar(List<Car> cars) {
        Collections.sort(cars);
        return cars.get(0);
    }

    private List<String> getWinnerNamesWithFirstCar(Car firstCar, List<Car> cars) {
        for (Car car : cars) {
            addWinnerByFastestCar(car, firstCar);
        }
        return getWinnerNames();
    }

    private void addWinnerByFastestCar(Car car, Car fastest) {
        if (fastest.compareTo(car) == 0) {
            winnerNames.add(car.getCarName());
        }
    }

    public List<String> getWinnerNames() {
        return this.winnerNames;
    }
}
