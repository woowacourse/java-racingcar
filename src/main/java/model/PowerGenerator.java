package model;

import java.util.Random;

public class PowerGenerator {

    private final Random powerGenerator;

    public PowerGenerator(Random powerGenerator) {
        this.powerGenerator = powerGenerator;
    }

    public int generate(int upperBound) {
        return powerGenerator.nextInt(upperBound);
    }
}
