package racingcar.model;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNo {
    private static final int RANDOM_BOUND = 10;

    public static int getNumber() {
        return ThreadLocalRandom.current().nextInt(RANDOM_BOUND);
    }
}
