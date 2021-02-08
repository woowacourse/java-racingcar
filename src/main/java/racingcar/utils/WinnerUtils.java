package racingcar.utils;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class WinnerUtils {

    private WinnerUtils() {
    }

    public static List<String> findWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return findCarsLocatedAt(cars, maxPosition);
    }

    private static int findMaxPosition(List<Car> cars) {
        return cars.stream().map(Car::getPosition).reduce(Integer::max).orElse(-1);
    }

    private static List<String> findCarsLocatedAt(List<Car> cars, int position) {
        return cars.stream().filter(car -> car.getPosition() == position).map(Car::getName).collect(
            Collectors.toList());
    }
}