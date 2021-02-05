package racingcar.domain.car.util;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random RANDOM = new Random();
    private static final int END_EXCLUSIVE_NUMBER = 10;

    public int generate() {
        return RANDOM.nextInt(END_EXCLUSIVE_NUMBER);
    }
}
