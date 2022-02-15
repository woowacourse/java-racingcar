package racingcar.utils;

import java.util.Random;

public class RandomForwardJudgment {
    private static final Random random = new Random();
    private static final int RANDOM_BOUND = 10;
    private static final int FORWARD_NUMBER = 4;

    static {
        random.setSeed(System.currentTimeMillis());
    }

    public static boolean canForward() {
        return random.nextInt(RANDOM_BOUND) >= FORWARD_NUMBER;
    }
}
