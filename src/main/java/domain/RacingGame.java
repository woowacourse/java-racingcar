package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final static int MIN_MOVE_NUMBER = 4;
    private final static int GAME_OVER_COUNT = 0;

    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    private int gameTrialCount;

    public RacingGame(List<Car> cars, int gameTrialCount, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.gameTrialCount = gameTrialCount;
        this.numberGenerator = numberGenerator;
    }

    public List<Car> run() {
        start();
        finish();
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinners() {
        int maxMoveCount = getMaxMoveCount();
        return cars.stream()
                .filter(car -> car.isWinner(maxMoveCount))
                .collect(Collectors.toList());
    }

    public boolean canContinue() {
        return gameTrialCount > GAME_OVER_COUNT;
    }

    private void start() {
        cars.stream()
                .filter(car -> car.canMove(numberGenerator.generate(), MIN_MOVE_NUMBER))
                .forEach(Car::move);
    }

    private void finish() {
        gameTrialCount--;
    }

    private int getMaxMoveCount() {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .getAsInt();
    }
}
