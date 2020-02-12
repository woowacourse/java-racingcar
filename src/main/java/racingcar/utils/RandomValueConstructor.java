package racingcar.utils;

import java.util.Random;

public class RandomValueConstructor {
    public static final int VALUE_LIMIT = 10;
    private Random random = new Random();

    public int getRandomNumber() {
        return random.nextInt(VALUE_LIMIT);
    }
}
