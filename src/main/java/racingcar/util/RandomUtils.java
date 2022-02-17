package racingcar.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    private RandomUtils() {
    }

    public static int generateNumber(int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        if (min == max) {
            return min;
        }
        return min + ThreadLocalRandom.current().nextInt(max - min);
    }
}