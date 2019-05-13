package racingcar.domain;

import java.util.Random;

public class Rule {
    private final static int RANDOM_NUMBER_OFFSET = 10;
    private final static int MOVE_OFFSET = 4;

    protected static boolean isPossibleMove() {
        return generateRandomNumber() > MOVE_OFFSET;
    }

    /* For Test */
    protected static boolean isPossibleMove(int num) {
        return num > MOVE_OFFSET;
    }

    private static int generateRandomNumber() {
        return new Random().nextInt(RANDOM_NUMBER_OFFSET);
    }
}
