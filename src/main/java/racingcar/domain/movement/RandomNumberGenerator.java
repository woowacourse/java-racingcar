package racingcar.domain.movement;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final Random random = new Random();

    @Override
    public int generate(final int bound) {
        return random.nextInt(bound);
    }
}
