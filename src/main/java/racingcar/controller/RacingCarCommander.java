package racingcar.controller;

import java.util.Random;

public class RacingCarCommander implements MovingStrategy {

    private static final Random random = new Random();
    private static final int MAX_NUMBER = 10;
    private static final int MOVABLE_NUMBER = 4;

    @Override
    public boolean isMovable() {
        return generateRandomNumber() >= MOVABLE_NUMBER;
    }

    public int generateRandomNumber() {
        return random.nextInt(MAX_NUMBER);
    }
}
