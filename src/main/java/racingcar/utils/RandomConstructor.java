package racingcar.utils;

import java.util.Random;

public class RandomConstructor {
    public static final int LIMIT = 10;
    private Random random = new Random();

    public int getRandomNumber() {
        return random.nextInt(LIMIT);
    }
}
