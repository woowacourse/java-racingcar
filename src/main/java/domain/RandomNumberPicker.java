package domain;

import java.util.Random;

public class RandomNumberPicker implements NumberPicker {
    private static final Random random = new Random();
    private static final int BOUND = 10;

    @Override
    public int pickNumber() {
        return random.nextInt(BOUND);
    }
}
