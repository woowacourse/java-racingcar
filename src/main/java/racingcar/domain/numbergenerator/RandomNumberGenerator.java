package racingcar.domain.numbergenerator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final Random random = new Random();
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    public int generate() {
        return MIN_RANDOM_NUMBER + random.nextInt(MAX_RANDOM_NUMBER - MIN_RANDOM_NUMBER + 1);
    }
}
