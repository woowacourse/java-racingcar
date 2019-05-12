package racingcar.domain;

import java.util.ArrayList;

public class WinningCarsFinder {
    private ArrayList<Car> winningCars = new ArrayList<>();
    private int farthestPosition = -1;


    public WinningCarsFinder(ArrayList<Car> cars) {
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

    public ArrayList<Car> getWinningCars() {
        return this.winningCars;
    }
}

