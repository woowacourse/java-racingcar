package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;

public class Winners {
    private Winners() {
    }

    public static List<String> makeWinners(List<Car> cars) {
        int winnerPosition = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            winnerPosition = makeWinnerPosition(winners, winnerPosition, car);
        }
        return winners;
    }

    private static int makeWinnerPosition(List<String> winners, int winnerPosition, Car car) {
        if (car.getPosition().length() < winnerPosition) {
            return winnerPosition;
        }
        if (car.getPosition().length() > winnerPosition) {
            winners.clear();
            winnerPosition = car.getPosition().length();
        }
        winners.add(car.getName());
        return winnerPosition;
    }
}
