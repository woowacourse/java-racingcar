package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningCarsFinder {
    private List<Car> winningCars = new ArrayList<>();
    private int farthestPosition = -1;


    public WinningCarsFinder(List<Car> cars) {
        for (Car car : cars) {
            findSamePosition(car);
            findFarthestPosition(car);
        }
    }

    private void findFarthestPosition(Car car) {
        if (this.farthestPosition < car.getPosition()) {
            winningCars.clear();
            winningCars.add(car);
            this.farthestPosition = car.getPosition();
        }
    }

    private void findSamePosition(Car car) {
        if (this.farthestPosition == car.getPosition()) {
            winningCars.add(car);
        }
    }

    public List<Car> getWinningCars() {
        return this.winningCars;
    }
}

