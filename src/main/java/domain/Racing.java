package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Racing {

    private Map<Car, Integer> board;
    private int winnerDistance;
    private Random random;
    private final int UPPER_BOUND = 10;
    private final int START_DISTANCE = 0;

    public Racing(List<String> carNames) {
        board = new LinkedHashMap<>();
        winnerDistance = START_DISTANCE;
        random = new Random();
        carGenerate(carNames);
    }

    private void carGenerate(List<String> carNames) {
        carNames.forEach(carName -> board.put(new Car(carName), START_DISTANCE));
    }

    public void moveAll() {
        for (Car car : board.keySet()) {
            move(car);
        }
    }

    private void move(Car car) {
        boolean isPossibleToMove = car.move(randomNumber());

        if (isPossibleToMove) {
            int distance = board.get(car) + 1;
            updateWinnerDistance(distance);
            board.put(car, distance);
        }
    }

    private void updateWinnerDistance(int distance) {
        winnerDistance = Math.max(winnerDistance, distance);
    }

    private int randomNumber() {
        return random.nextInt(UPPER_BOUND);
    }
}
