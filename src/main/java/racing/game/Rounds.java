package racing.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Rounds {
    private static final int MAX_NO = 10;

    private static int getRandomValue() {
        return (int) (Math.random() * MAX_NO);
    }

    static void doRound(List<Car> cars) {
        for (Car car : cars) {
            car.move(getRandomValue());
        }
    }

    static List<Car> calculateChampions(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int winnerPosition = Collections.max(cars, (car1, car2) -> car1.compareTo(car2)).getPosition();
        for (Car car : cars) {
            if (car.matchPosition(winnerPosition))
                winners.add(car);
        }
        return winners;
    }
}
