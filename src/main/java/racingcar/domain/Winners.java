package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private Winners() {
    }

    private static final List<Car> winners = new ArrayList<>();
    private static int winnerPosition;

    public static void setWinners() {
        winnerPosition = getWinnerPosition();
        for (Car car : Cars.getCars()) {
            setWinner(car);
        }
    }

    public static List<String> getWinnersNames() {
        return Collections.unmodifiableList(winners.stream()
                .map(Car::getName).collect(Collectors.toList()));
    }

    private static int getWinnerPosition() {
        return Cars.getMaxPositionByCars();
    }

    private static void setWinner(final Car car) {
        if (car.isWinnerPosition(winnerPosition)) {
            winners.add(car);
        }
    }
}

