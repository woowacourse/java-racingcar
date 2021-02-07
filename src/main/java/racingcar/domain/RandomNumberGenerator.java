package racingcar.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final Random random;
    private final int MIN_RANDOM_NUMBER = 0;
    private final int MAX_RANDOM_NUMBER = 9;

    public RandomNumberGenerator() {
        random = new Random();
    }

    public int generate() {
        return MIN_RANDOM_NUMBER + random.nextInt(MAX_RANDOM_NUMBER - MIN_RANDOM_NUMBER + 1);
    }
}
