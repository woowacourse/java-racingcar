package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private final int minimum;
    private final int maximum;
    private final Random random = new Random();

    public RandomNumberGenerator(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    @Override
    public int generate() {
        return minimum + random.nextInt(maximum + 1);
    }
}
