package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerFinder {

    private static List<String> winners;
    private static int maxPosition;

    private WinnerFinder() {
    }

    public static List<String> getWinners(List<Car> cars) {
        winners = new ArrayList<>();
        maxPosition = -1;
        for (Car car : cars) {
            updateWinners(car);
        }
        return winners;
    }

    private static void updateWinners(Car car) {
        if (car.getPosition() < maxPosition) {
            return;
        }
        if (car.getPosition() > maxPosition) {
            maxPosition = car.getPosition();
            winners.clear();
        }
        winners.add(car.getName());
    }

}
