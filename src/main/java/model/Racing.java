package model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Racing {

    private final int UPPER_BOUND = 10;
    private final int START_DISTANCE = 0;
    private final String STICK = "-";

    private Map<Car, Integer> board;
    private int winnerDistance;
    private Random random;

    public Racing(List<String> carNames, Random random) {
        board = new LinkedHashMap<>();
        winnerDistance = START_DISTANCE;
        this.random = random;
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

    @Override
    public String toString() {
        return board.keySet()
                .stream()
                .map(this::makeResult)
                .collect(Collectors.joining());
    }

    private String makeResult(Car car) {
        return car.toString() + " : " + STICK.repeat(board.get(car)) + "\n";
    }

    public List<Car> winner(){
        return board.keySet()
                .stream()
                .filter(car->board.get(car)==winnerDistance)
                .collect(Collectors.toList());
    }
}
