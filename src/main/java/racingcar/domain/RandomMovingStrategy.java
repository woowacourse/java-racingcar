package racingcar.domain;

import racingcar.util.RandomGenerator;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int THRESHOLD = 4;

    public boolean isMovable() {
        return RandomGenerator.generateRandomNumber() >= THRESHOLD;
    }
}
