package racingcargame.genrator;

import java.util.Random;

public class RandomGenerator {
    private static final int MAX_RANDOM_NO = 9;
    private static Random random = new Random();

    public static int generateRandom() {
        return random.nextInt(MAX_RANDOM_NO);
    }
}
