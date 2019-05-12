package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {
    public static List<String> findWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return getWinners(cars, maxPosition);
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
}
