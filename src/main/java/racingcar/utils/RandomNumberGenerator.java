package racingcar.utils;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random RANDOM = new Random();

    private RandomNumberGenerator() {}

    public static int generate(int minNumber, int maxNumber) {
        if (minNumber > maxNumber) {
            throw new IllegalArgumentException();
        }

        if (minNumber < 0) {
            throw new IllegalArgumentException();
        }

        if (minNumber == maxNumber) {
            return minNumber;
        }

        return minNumber + RANDOM.nextInt(maxNumber - minNumber + 1);
    }
}
