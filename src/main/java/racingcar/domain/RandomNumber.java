package racingcar.domain;

import java.util.Random;

public class RandomNumber {
    private static final int MINIMUM_NUMBER = 0;
    private static final int MAXIMUM_NUMBER = 9;

    private static final Random random = new Random();

    private RandomNumber() {
    }

    public static int make() {
        return MINIMUM_NUMBER + random.nextInt(MAXIMUM_NUMBER - MINIMUM_NUMBER + 1);
    }
}

