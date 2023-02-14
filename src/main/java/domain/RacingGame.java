package domain;

import validation.ErrorMessage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final static int GAME_OVER_COUNT = 0;
    private static final int MIN_GAME_TRIAL_COUNT = 1;

    private final Cars cars;
    private final NumberGenerator numberGenerator;

    private int gameTrialCount;

    public RacingGame(Cars cars, int gameTrialCount, NumberGenerator numberGenerator) {
        validate(gameTrialCount);
        this.cars = cars;
        this.gameTrialCount = gameTrialCount;
        this.numberGenerator = numberGenerator;
    }

    private void validate(int gameTrialCount) {
        if (gameTrialCount < MIN_GAME_TRIAL_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_TRIAL_NUMBER.getMessage());
        }
    }

    public Cars run() {
        start();
        finish();
        return cars;
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }

    public boolean canContinue() {
        return gameTrialCount > GAME_OVER_COUNT;
    }

    private void start() {
        cars.move(numberGenerator);
    }

    private void finish() {
        gameTrialCount--;
    }
}
