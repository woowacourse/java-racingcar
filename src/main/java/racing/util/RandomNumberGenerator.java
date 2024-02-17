package racing.util;

import java.util.Random;

public class RandomNumberGenerator {

    private final int bound;
    private final int start;

    public RandomNumberGenerator(int bound, int start) {
        this.bound = bound;
        this.start = start;
    }

    public int generate() {
        Random random = new Random();
        return random.nextInt(bound) + start;
    }
}
