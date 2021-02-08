package racingcar.domain.car;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final Random RANDOM = new Random();
    private static final int END_EXCLUSIVE_NUMBER = 10;

    @Override
    public int generate() {
        return RANDOM.nextInt(END_EXCLUSIVE_NUMBER);
    }
}
