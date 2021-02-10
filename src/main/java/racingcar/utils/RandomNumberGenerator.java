package racingcar.utils;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int DOWN_LIMIT = 0;
    private static final int UP_LIMIT = 9;
    private static final int CALIBRATION_NUMBER = 1;
    private static Random random = new Random();

    public static int turnNumber() {
        return DOWN_LIMIT + random.nextInt(UP_LIMIT + CALIBRATION_NUMBER);
    }
}
