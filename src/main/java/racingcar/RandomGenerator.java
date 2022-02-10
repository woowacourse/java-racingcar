package racingcar;

import java.util.Random;

public class RandomGenerator {

    private static final Random random = new Random();
    private static final int MAX_NUMBER = 10;

    public boolean isMovable() {
        if (generateRandomNumber() >= 4) {
            return true;
        }
        return false;
    }

    public int generateRandomNumber() {
        return random.nextInt(MAX_NUMBER);
    }
}
