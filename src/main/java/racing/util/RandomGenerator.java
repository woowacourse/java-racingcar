package racing.util;

import java.util.Random;

public class RandomGenerator {
    private static final int END_BOUNDARY_NUMBER = 10;

    static public int generate() {
        Random random = new Random();
        return random.nextInt(END_BOUNDARY_NUMBER);
    }
}
