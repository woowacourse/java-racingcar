package racingcargame.genrator;

import java.util.Random;

public class RandomGenerator {

    private static final int RANDOM_NUMBER_BOUND = 9;

    private static Random random = new Random();

    public static int generateRandom() {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}
