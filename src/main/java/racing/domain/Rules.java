package racing.domain;

import java.util.Random;

public class Rules {
    public static final int MAX_CAR_NAME = 5;
    public static final int MIN_MOVABLE_NUMBER = 4;
    public static final int RANDOM_NUMBER_RANGE = 10;

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }
}
