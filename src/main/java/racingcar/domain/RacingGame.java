package racingcar.domain;

import java.util.List;

//TODO
// racingGameDto
public class RacingGame {
    public static final int MINIMUM_NUMBER_OF_ROUNDS = 1;
    public static final String UNAVAILABLE_NUMBER_OF_ROUNDS_MESSAGE = "[ERROR] 라운드 횟수는 1이상이어야 합니다";
    public static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해 주세요.";
    private static final int INIT_ROUND = 0;

    private final Cars cars;
    private final int numberOfRounds;
    private int currentRound;

    public RacingGame(Cars cars, int numberOfRounds) {
        validatePositiveNumber(numberOfRounds);
        this.cars = cars;
        this.numberOfRounds = numberOfRounds;
        this.currentRound = INIT_ROUND;
    }

    private static void validatePositiveNumber(int numberOfRounds) {
        if (numberOfRounds < MINIMUM_NUMBER_OF_ROUNDS) {
            throw new IllegalArgumentException(UNAVAILABLE_NUMBER_OF_ROUNDS_MESSAGE);
        }
    }

    public void playAnotherRound() {
        cars.moveCars();
        currentRound++;
    }

    public boolean isFinished() {
        return currentRound == numberOfRounds;
    }

    public List<Car> getWinners() {
        return cars.findWinners();
    }

    public Cars getCars() {
        return cars.copy();
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public int getCurrentRound() {
        return currentRound;
    }
}