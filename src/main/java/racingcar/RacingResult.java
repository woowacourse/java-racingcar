package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {
    public static void process(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        List<String> winners = getWinners(cars, maxPosition);
        printWinners(winners);
    }

    protected static int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }
        return maxPosition;
    }

    protected static List<String> getWinners(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.matchPosition(maxPosition)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private static void printWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println(result + "가 최종 우승했습니다.");
    }
}
