package model;

import java.util.ArrayList;
import java.util.List;

public class Winner {


    public static int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public static List<String> setWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition(cars);
        for (Car car : cars) {
            if (maxPosition == car.getPosition()) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
