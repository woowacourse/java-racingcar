package racingcargame.genrator;

import java.util.Random;

public class RandomGenerator {
    private static Random random = new Random();

    public static int generateRandom() {
        return random.nextInt(9);
    }
}
