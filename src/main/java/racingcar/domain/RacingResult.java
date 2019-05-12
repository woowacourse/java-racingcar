package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {
    public static void process(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        List<String> winners = getWinners(cars, maxPosition);
        printWinners(winners);
    }

    protected static int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.findPositionBiggerThan(maxPosition);
        }
        return maxPosition;
    }

    protected static List<String> getWinners(List<Car> cars, int maxPosition) {
        return cars.stream()
                .filter(car -> car.matchPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static void printWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println(result + "가 최종 우승했습니다.");
    }
}
