package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private final Random random = new Random();

    public int generate() {
        return random.nextInt(10);
    }
}
