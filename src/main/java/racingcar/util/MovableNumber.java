package racingcar.util;

import java.util.Random;

public class MovableNumber implements RandomUtil {
    private static final Random random = new Random();

    @Override
    public int create(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
