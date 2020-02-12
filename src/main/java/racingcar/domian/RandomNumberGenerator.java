package racingcar.domian;

import java.util.Random;

public class RandomNumberGenerator {
    private static Random random = new Random();

    public static int generateRandom() {
        return random.nextInt(10);
    }
}
