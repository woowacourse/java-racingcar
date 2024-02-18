package racing.util;

import java.util.Random;

public class RandomGenerator {
    static public int generate() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
