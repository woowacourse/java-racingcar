package racing.util;

import java.util.Random;

public class RandomGenerator {

    public static int generate() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
