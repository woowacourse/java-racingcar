package racingcar.domain;

import java.util.Random;

class RandomNumberWhetherMove {
    private static final int MOVE_THRESHOLD = 4;
    private static final int RANDOM_MAX = 10;
    private static final int RANDOM_MIN = 0;

    private int randomNumber;

    RandomNumberWhetherMove() {
        randomNumber = new Random().nextInt(RANDOM_MAX - RANDOM_MIN) + RANDOM_MIN;
    }

    boolean canMove() {
        return randomNumber >= MOVE_THRESHOLD;
    }
}
