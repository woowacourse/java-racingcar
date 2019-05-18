package racingcargame.model;

import java.util.ArrayList;
import java.util.List;

public class Judge {
    public static List<Car> decideWinners(List<Car> cars) {
        int max = findMax(cars);
        List<Car> winners = findWinners(cars, max);
        return winners;
    }

    private static int findMax(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            max = car.findMax(max);
        }
        return max;
    }

    private static List<Car> findWinners(List<Car> cars, int max) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            decideWinners(winners, car, max);
        }
        return winners;
    }

    private static void decideWinners(List<Car> winners, Car car, int max) {
        if(car.isMax(max)) {
            winners.add(car);
        }
    }
}
