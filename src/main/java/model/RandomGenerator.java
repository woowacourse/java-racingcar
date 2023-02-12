package model;

import java.util.Random;

public class RandomGenerator {

    private final Random randomGenerator;

    public RandomGenerator(Random powerGenerator) {
        this.randomGenerator = powerGenerator;
    }

    public int generate(int upperBound) {
        return randomGenerator.nextInt(upperBound);
    }
}
