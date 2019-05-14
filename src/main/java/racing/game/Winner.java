package racing.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Winner {
    private final String JOIN_DELIMITER = ", ";
    private List<Car> winners;

    public Winner() {
        winners = new ArrayList<>();
    }

    Winner calculateChampions(List<Car> cars) {
        int winnerPosition = Collections.max(cars, (car1, car2) -> car1.compareTo(car2)).getPosition();
        for (Car car : cars) {
            if (car.matchPosition(winnerPosition))
                winners.add(car);
        }
        return this;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(JOIN_DELIMITER);
        for (Car winner : winners) {
            stringJoiner.add(winner.getName());
        }
        return stringJoiner.toString() + "가 최종 우승했습니다.";
    }
}
