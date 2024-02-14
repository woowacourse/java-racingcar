package racingcar.service;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random random = new Random();

    private RandomNumberGenerator() {
    }

    public static int generateRandomNumber(final int maximum) {
        return random.nextInt(maximum + 1); // bound 미만의 숫자를 return하기 때문에 +1
    }
}
