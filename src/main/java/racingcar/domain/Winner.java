package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Winner {
    private final static int EQUAL_VALUE = 0;

    public Winner() {
    }

    public static List<String> getWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        Car maxDistanceCar = Collections.max(cars);

        for (Car car : cars) {
            if (car.compareTo(maxDistanceCar) == EQUAL_VALUE) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
