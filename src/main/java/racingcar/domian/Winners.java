package racingcar.domian;

import racingcar.domian.car.Car;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    public static List<Car> findWinner(List<Car> cars) {
        int maxPosition = 0;
        for(Car car : cars) {
            maxPosition = car.getBiggerPosition(maxPosition);
        }
        return getWinners(cars, maxPosition);
    }

    private static List<Car> getWinners(List<Car> cars, int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for(Car car : cars) {
            if(car.isWinner(maxPosition)){
                winners.add(car);
            }
        }
        return winners;
    }
}