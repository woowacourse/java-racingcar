package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> winners = new ArrayList<>();
    private int winnerPosition;

    public Winners(Cars cars) {
        winnerPosition = getWinnerPosition(cars);
        for (Car car : cars.getCars()) {
            setWinner(car);
        }
    }

    public List<String> getWinnersNames() {
        return Collections.unmodifiableList(winners.stream()
                .map(Car::getName).collect(Collectors.toList()));
    }

    private int getWinnerPosition(final Cars cars) {
        return cars.getMaxPositionByCars();
    }

    private void setWinner(final Car car) {
        if (car.isWinnerPosition(winnerPosition)) {
            winners.add(car);
        }
    }
}

