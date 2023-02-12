package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int DIGIT_MAX = 10;

    @Override
    public int makeDigit() {
        Random random = new Random();
        return random.nextInt(DIGIT_MAX);
    }
}
