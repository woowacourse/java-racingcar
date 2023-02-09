package model;

import java.util.Random;

public class RandomNumberGenerator {

    private final Random random;

    public RandomNumberGenerator(Random random) {
        this.random = random;
    }

    public int generate(int upperBound) {
        return random.nextInt(upperBound);
    }
}
