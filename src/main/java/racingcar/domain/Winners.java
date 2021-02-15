package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> winners;

    public Winners(final List<Car> cars) {
        this.winners = new ArrayList<>();
        int winnerPosition = findWinnerPosition(cars);
        for (Car car : cars) {
            addWinners(winnerPosition, car);
        }
    }

    private int findWinnerPosition(final List<Car> cars) {
        int winnerPosition = 0;
        for (Car car : cars) {
            winnerPosition = findMaxPosition(winnerPosition, car);
        }
        return winnerPosition;
    }

    private int findMaxPosition(final int winnerPosition, final Car car) {
        return car.findBiggerPosition(winnerPosition);
    }

    private void addWinners(final int winnerPosition, final Car car) {
        if (car.isSamePosition(winnerPosition)) {
            winners.add(car);
        }
    }

    public List<Car> toList() {
        return new ArrayList<>(winners);
    }
}
