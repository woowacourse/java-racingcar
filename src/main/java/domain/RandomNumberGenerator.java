package domain;

import java.util.Random;

public class RandomNumberGenerator {

    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 9;

    public int generate() {
        Random random = new Random();
        return random.nextInt(MIN_VALUE, MAX_VALUE + 1);
    }
}