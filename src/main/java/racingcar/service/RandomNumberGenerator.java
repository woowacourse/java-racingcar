package racingcar.service;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random random = new Random();

    private RandomNumberGenerator() {
    }

    public static int generate(final int max) {
        return random.nextInt(max + 1); // bound 미만의 숫자를 return하기 때문에 +1
    }
}
