package domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final List<Car> winners;

    public Winner(List<Car> cars) {
        this.winners = getWinners(cars);
    }

    private int getMaxDistance(List<Car> cars) {
        int maxDistance = 0;

        for (Car car : cars) {
            maxDistance = car.getBiggerPosition(maxDistance);
        }
        return maxDistance;
    }

    private List<Car> getWinners(List<Car> cars) {
        int winDistance = getMaxDistance(cars);
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.isMaxPosition(winDistance)) {
                winners.add(car);
            }
        }
        return winners;
    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();

        for (Car car : winners) {
            winnerNames.add(car.getName());
        }
        return winnerNames;
    }
}
