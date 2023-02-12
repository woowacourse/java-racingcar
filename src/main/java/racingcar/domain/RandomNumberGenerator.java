package racingcar.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final Random RANDOM = new Random();

    public int generateNumber() {
        return RANDOM.nextInt(10);
    }
}
