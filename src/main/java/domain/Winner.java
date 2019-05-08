package domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    private int getMaxDistance() {
        int maxDistance = 0;

        for (Car car : cars) {
            maxDistance = car.getBiggerPosition(maxDistance);
        }
        return maxDistance;
    }

    public List<String> getWinners() {
        int winDistance = getMaxDistance();
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.isMaxPosition(winDistance)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
