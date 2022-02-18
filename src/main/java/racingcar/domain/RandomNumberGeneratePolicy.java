package racingcar.domain;

import java.util.Random;

public class RandomNumberGeneratePolicy implements NumberGeneratePolicy {
    private static final int RANDOM_MAXIMUM = 10;

    @Override
    public int generate() {
        return new Random().nextInt(RANDOM_MAXIMUM);
    }
}
