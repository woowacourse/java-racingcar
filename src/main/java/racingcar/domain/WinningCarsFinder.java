package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningCarsFinder {
    public static List<Car> findWinningCars(List<Car> cars) {
        List<Car> winningCars = new ArrayList<>();
        int farthestPosition = -1;

        for (Car car : cars) {
            if (car.isFartherPosition(farthestPosition)) {
                winningCars.clear();
                winningCars.add(car);
                farthestPosition = car.getPosition();
                continue;
            }
            if (car.isSamePosition(farthestPosition)) {
                winningCars.add(car);
            }
        }
        return winningCars;
    }
}
