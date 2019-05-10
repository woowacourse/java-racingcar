package racingcar.domain;

import java.util.ArrayList;

public class WinningCarsFinder {
    public static ArrayList<Car> findWinningCars(ArrayList<Car> cars) {
        ArrayList<Car> winningCars = new ArrayList<>();
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
