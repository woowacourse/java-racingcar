package racingcar.utils;

import java.util.Random;

public class RandomForwardJudgment {
    private static final Random random;
    private static final int FORWARD_NUMBER = 4;
    private static final int RANDOM_BOUND = 10;

    static {
        random = new Random();
        random.setSeed(System.currentTimeMillis());
    }

    public static boolean canForward() {
        return random.nextInt(RANDOM_BOUND) >= FORWARD_NUMBER;
    }
}
