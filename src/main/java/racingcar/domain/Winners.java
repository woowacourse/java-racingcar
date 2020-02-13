package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private static List<Car> winners = new ArrayList<>();

    public static void selectWinners(List<Car> cars) {
        Car maxDistanceCar = cars.stream()
                .max(Car::compareTo)
                .get();
        for (Car car : cars) {
            if (car.isMaxPosition(maxDistanceCar)) {
                winners.add(car);
            }
        }
    }

    public static String getWinners() {
        return winners.stream()
                .map(Car::toString)
                .collect(Collectors
                        .joining(","));
    }
}