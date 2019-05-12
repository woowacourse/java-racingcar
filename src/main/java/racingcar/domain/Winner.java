package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Winner {
    private final static int EQUAL_VALUE = 0;

    private List<Car> cars;

    public Winner(List<Car> carList) {
        this.cars = carList;
    }

    public List<String> getWinner() {
        int maxDistance;
        List<String> winners = new ArrayList<>();

        maxDistance = getMaxDistance();
        for (Car car : cars) {
            if (car.compareToPosition(maxDistance) == EQUAL_VALUE) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    protected int getMaxDistance() {
        int maxDistance = 0;

        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.compareToPosition(maxDistance));
        }

        return maxDistance;
    }
}
