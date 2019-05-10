package domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getWinnerList() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();

        for (Car car : cars) {
            if (car.isEqualPosition(maxPosition)) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = car.getBiggerPosition(maxPosition);
        }

        return maxPosition;
    }
}
