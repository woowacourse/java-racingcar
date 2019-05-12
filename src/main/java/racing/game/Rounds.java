package racing.game;

import java.util.ArrayList;
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
        int winnerPosition = 0;
        for (Car car : cars) {
            if (car.matchPosition(winnerPosition) == 0)
                winners.add(car);
            if (car.matchPosition(winnerPosition) == 1) {
                winners.clear();
                winnerPosition = car.getPosition();
                winners.add(car);
            }
        }
        return winners;
    }
}
