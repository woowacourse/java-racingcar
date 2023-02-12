package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private final Random random = new Random();

    @Override
    public int generate(int startInclusive, int endInclusive) {
        return startInclusive + random.nextInt(endInclusive + 1);
    }
}
