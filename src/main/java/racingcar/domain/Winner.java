package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Winner {
    private List<Car> cars;

    public Winner(List<Car> carList) {
        this.cars = carList;
    }

    public String getWinner() {
        int maxDistance;
        List<String> winners = new ArrayList<>();

        maxDistance = getMaxDistance();
        for (Car car : cars) {
            if (car.getPosition() == maxDistance) {
                winners.add(car.getName());
            }
        }

        return String.join(",", winners);
    }

    protected int getMaxDistance() {
        int maxDistance = 0;

        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getPosition());
        }

        return maxDistance;
    }
}
