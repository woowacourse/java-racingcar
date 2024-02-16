package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 9;

    @Override
    public int generate() {
        Random random = new Random();
        return random.nextInt(MIN_VALUE, MAX_VALUE + 1);
    }
}