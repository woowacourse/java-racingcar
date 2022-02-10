package racingcar;

import java.util.Random;

public class RandomGenerator {

    private static final Random random = new Random();

    public int generateRandomNumber() {
        return random.nextInt(10);
    }
}
