package racingcar.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    public static int generateRandomNumber(int bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }
}
