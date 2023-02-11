package domain;

import java.util.Random;

public class RandomPicker implements Pickable {

    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;

    @Override
    public int pickNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_UPPER_BOUND);
    }
}
