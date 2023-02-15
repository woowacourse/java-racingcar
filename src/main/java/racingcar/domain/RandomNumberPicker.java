package racingcar.domain;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberPicker {
    private static final int MAX_NUMBER = 10;

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public int pickNumber() {
        return random.nextInt(MAX_NUMBER);
    }
}
