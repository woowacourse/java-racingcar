package racingcar.controller;

import racingcar.domain.Car;
import java.util.ArrayList;

public class ResultController {
    public ArrayList<Car> findWinners(ArrayList<Car> carList) {
        ArrayList<Car> winners = new ArrayList<>();
        int farthestPosition = -1;

        for (Car car : carList) {
            if(car.isFartherPosition(farthestPosition)) {
                winners.clear();
                winners.add(car);
                farthestPosition = car.getPosition();
                continue;
            }
            if(car.isSamePosition(farthestPosition)) {
                winners.add(car);
            }
        }
        return winners;
    }
}
