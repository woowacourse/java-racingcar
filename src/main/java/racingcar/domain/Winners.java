package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private Winners() {
    }

    private static List<Car> winners = new ArrayList<>();
    private static int winnerPosition;

    public static void allocateWinners(List<Car> cars) {
        setWinnerPosition(cars);
        for (Car car : cars) {
            allocateWinner(car);
        }
    }

    public static List<String> getWinnersNames() {
        return winners.stream()
                .map(Car::getName).collect(Collectors.toList());
    }

    private static void setWinnerPosition(List<Car> cars) {
        for (Car car : cars) {
            winnerPosition = Math.max(winnerPosition, car.getPosition());
        }
    }

    private static void allocateWinner(Car car) {
        if (car.isMaxPosition(winnerPosition)) {
            winners.add(car);
        }
    }
}

