package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> winners = new ArrayList<>();

    public Winners(List<Car> cars) {
        int winnerPosition = findWinnerPosition(cars);
        for (Car car : cars) {
            addWinners(winnerPosition, car);
        }
    }

    private int findWinnerPosition(List<Car> cars) {
        int winnerPosition = 0;
        for (Car car : cars) {
            winnerPosition = findMaxPosition(winnerPosition, car);
        }
        return winnerPosition;
    }

    private int findMaxPosition(int winnerPosition, Car car) {
        return car.findBiggerPosition(winnerPosition);
    }

    private void addWinners(int winnerPosition, Car car) {
        if (car.isSamePosition(winnerPosition)) {
            winners.add(car);
        }
    }

    public List<Car> toList() {
        return winners;
    }
}
