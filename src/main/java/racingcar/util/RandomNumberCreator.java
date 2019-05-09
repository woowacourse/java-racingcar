package racingcar.util;

import java.util.Random;

public class RandomNumberCreator {
    private static final Random random = new Random();

    public static int create(int start, int end) {
        return random.nextInt(end - start + 1) + start;
    }
}
