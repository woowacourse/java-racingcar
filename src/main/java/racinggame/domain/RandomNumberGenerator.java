package racinggame.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{
    private static final int RANDOM_BOUND = 10;

    public int generateNumber() {
        Random random = new Random();

        return random.nextInt(RANDOM_BOUND);
    }
}
