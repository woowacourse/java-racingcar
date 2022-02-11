package racingcar.util;

import java.util.Random;

public class RandomNumber implements RandomUtil {
    private static final Random random = new Random();

    @Override
    public int createRandom(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
