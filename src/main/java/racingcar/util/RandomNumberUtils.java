package racingcar.util;

import java.util.Random;


public class RandomNumberUtils {
    private static final Random random = new Random();

    public static int generate(int min, int max) {
        return random.nextInt(min, max);
    }
}
