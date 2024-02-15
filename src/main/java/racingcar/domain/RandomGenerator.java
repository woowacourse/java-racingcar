package racingcar.domain;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    public static int getRandomNumberUnderTen() {
        return random.nextInt(10);
    }
}
