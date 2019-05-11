package domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final List<String> winners;

    public Winner(List<Car> cars) {
        this.winners = getWinnerList(cars);
    }

    private List<String> getWinnerList(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition(cars);

        for (Car car : cars) {
            if (car.isEqualPosition(maxPosition)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = car.getBiggerPosition(maxPosition);
        }
        return maxPosition;
    }

    public List<String> getWinners() {
        return winners;
    }
}
