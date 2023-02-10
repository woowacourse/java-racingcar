package racingcar.domain;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberPicker implements NumberPicker {

    private static final int MAX_NUMBER = 10;

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public int pickNumber() {
        return random.nextInt(MAX_NUMBER);
    }
}
