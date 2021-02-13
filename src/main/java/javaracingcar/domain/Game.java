package javaracingcar.domain;

import java.util.regex.Pattern;

public class Game {
    private final Cars cars;
    private int trial;

    private Game(String carNames, int trial) {
        this.cars = new Cars(carNames);
        this.trial = trial;
    }

    public Cars getCars() {
        return cars;
    }

    public static Game init(String carNames, String trial) {
        validateNotNull(trial);
        validatePositiveInt(trial);
        return new Game(carNames, Integer.parseInt(trial));
    }

    private static void validateNotNull(String trial) {
        if (trial == null) {
            throw new IllegalArgumentException("null이 입력되었습니다.");
        }
    }

    private static int validatePositiveInt(String trial) {
        if (!Pattern.matches("^[1-9]+[0-9]*$", trial)) {
            throw new IllegalArgumentException("양의 정수가 아닙니다.");
        }
        return Integer.parseInt(trial);
    }

    public void moveCars() {
        cars.playMoveOrStop();
    }

    public void reduceOneTrial() {
        trial--;
    }

    public boolean isEnd() {
        return trial == 0;
    }
}
