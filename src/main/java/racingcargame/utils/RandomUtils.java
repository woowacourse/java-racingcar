package racingcargame.utils;

import java.util.Random;

public class RandomUtils {
    private final static Random RANDOM = new Random();

    private RandomUtils() {
    }

    public static int getRandomNumber() {
        return RANDOM.nextInt(10);
    }
}
