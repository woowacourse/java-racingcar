package util;

import java.util.Random;

public class RandomUtil {

    private static final int BOUND = 10;
    private static Random random = new Random();

    public static int getDigit() {
        return random.nextInt(BOUND);
    }
}
