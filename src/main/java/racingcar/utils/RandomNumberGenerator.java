package racingcar.utils;

import java.util.Random;

public class RandomNumberGenerator {
    public static int generate() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
