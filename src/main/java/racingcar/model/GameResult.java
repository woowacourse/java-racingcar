package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    public static List<String> racingResult(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxDistance = 0;

        maxDistance = getMaxDistance(cars, maxDistance);
        winners = getWinners(cars, winners, maxDistance);

        return winners;
    }

    private static List<String> getWinners(List<Car> cars, List<String> winners, int maxDistance) {
        for (Car car : cars) {
            winners = checkMaxPosition(car, winners, maxDistance);
        }
        return winners;
    }

    private static int getMaxDistance(List<Car> cars, int maxDistance) {
        for (Car car : cars) {
            maxDistance = getMaxDistance(maxDistance, car);
        }
        return maxDistance;
    }

    public static int getMaxDistance(int maxDistance, Car car) {
        return car.comparePosition(maxDistance);
    }

    public static List<String> checkMaxPosition(Car car, List<String> winners, int maxDistance) {
        if (!car.matchPosition(maxDistance).equals("")) {
            winners.add(car.matchPosition(maxDistance));
        }

        return winners;
    }
}
