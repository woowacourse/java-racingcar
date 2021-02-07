package racingcar.domain;

import java.util.List;

public class RacingGame {
    public static final int MINIMUM_NUMBER_OF_ROUNDS = 1;
    public static final String UNAVAILABLE_NUMBER_OF_ROUNDS_MESSAGE = "[ERROR] 라운드 횟수는 1이상이어야 합니다";
    public static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해 주세요.";

    private final Cars cars;
    private final int numberOfRounds;

    private static final int INIT_ROUND = 1;

    //TODO
    // 생성자에 numberOfRounds도 매개변수로 받기
    public RacingGame(List<String> names, int numberOfRounds) {
        validatePositiveNumber(numberOfRounds);
        this.cars = new Cars(names);
        this.numberOfRounds = numberOfRounds;
    }

    private static void validatePositiveNumber(int numberOfRounds) {
        if (numberOfRounds < MINIMUM_NUMBER_OF_ROUNDS) {
            throw new IllegalArgumentException(UNAVAILABLE_NUMBER_OF_ROUNDS_MESSAGE);
        }
    }

    public void playRound() {
        cars.moveCars();
    }

    public List<Car> getWinners() {
        return cars.findWinners();
    }

    public Cars getCars() {
        return cars;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }
}