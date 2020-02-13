package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

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
        return String.join(",", winners.toString());
    }
}