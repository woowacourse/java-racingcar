package racingcar.util;

import java.util.Random;

public class RandomIntGenerator implements IntGenerator {

    private static final int MINIMUM_NUMBER = 0;
    private static final int MAXIMUM_NUMBER = 9;

    private final Random random;

    public RandomIntGenerator() {
        this.random = new Random();
    }

    public int getOneNumber() {
        return random.ints(MINIMUM_NUMBER, (MAXIMUM_NUMBER + 1))
                .findFirst()
                .getAsInt();
    }
}
