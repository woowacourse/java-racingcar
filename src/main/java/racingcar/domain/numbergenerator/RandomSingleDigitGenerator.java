package racingcar.domain.numbergenerator;

import java.util.Random;

public class RandomSingleDigitGenerator implements NumberGenerator {

    public static final int BOUND = 10;
    private final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(BOUND);
    }
}
