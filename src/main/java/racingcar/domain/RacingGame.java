package racingcar.domain;

import java.util.List;

public class RacingGame {
    public static final int MINIMUM_NUMBER_OF_ROUNDS = 1;
    public static final String INVALID_NUMBER_OF_ROUNDS_MESSAGE = "[ERROR] 라운드 횟수는 1이상이어야 합니다";
    public static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해 주세요.";
    public static final int INIT_ROUND = 0;

    //TODO
    // 원시타입을 포장해보자
    // numberOfRounds
    // currentRound
    private final Cars cars;
    private final int numberOfRounds;
    private int currentRound;

    public RacingGame(Cars cars, String numberOfRounds) {
        validateIntegerNumber(numberOfRounds);
        validatePositiveNumber(numberOfRounds);
        this.cars = cars;
        this.numberOfRounds = Integer.parseInt(numberOfRounds);
        this.currentRound = INIT_ROUND;
    }

    public static void validateIntegerNumber(String numberOfRoundsInput) {
        try {
            Integer.parseInt(numberOfRoundsInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void validatePositiveNumber(String numberOfRounds) {
        if (Integer.parseInt(numberOfRounds) < MINIMUM_NUMBER_OF_ROUNDS) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_ROUNDS_MESSAGE);
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