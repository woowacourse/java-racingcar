package racing.utils;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    private RandomUtils() {
    }

    public static int getRandomNumber(final int startNumber, final int endNumber) {
        if (startNumber > endNumber) {
            throw new IllegalArgumentException();
        }
        if (startNumber < 0) {
            throw new IllegalArgumentException();
        }
        if (startNumber == endNumber) {
            return startNumber;
        }
        return startNumber + RANDOM.nextInt(endNumber - startNumber + 1);
    }
}
