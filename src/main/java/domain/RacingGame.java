package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int MIN_MOVE_NUMBER = 4;
    private static final int GAME_OVER_COUNT = 0;

    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    private GameTrialCount gameTrialCount;

    public RacingGame(List<Car> cars, GameTrialCount gameTrialCount, NumberGenerator numberGenerator) {
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
        return gameTrialCount.isGreaterThan(GAME_OVER_COUNT);
    }

    private void start() {
        cars.stream()
                .filter(car -> car.canMove(numberGenerator.generate(), MIN_MOVE_NUMBER))
                .forEach(Car::move);
    }

    private void finish() {
        gameTrialCount.reduce();
    }

    private int getMaxMoveCount() {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .getAsInt();
    }
}
