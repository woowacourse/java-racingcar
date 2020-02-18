package racingcar.domian;

import java.util.Random;

public class RandomNumber {
    private static final int RANDOM_MAX_LIMIT_NUMBER = 10;

    private static final Random random = new Random();

    public static int generateRandom() {
        return random.nextInt(RANDOM_MAX_LIMIT_NUMBER);
    }


}
