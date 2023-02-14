package racingcar.domain.numbergenerator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{

    private static final int BOUND = 10;

    private static final Random random = new Random();

    @Override
    public int generateNumber() {
        return random.nextInt(BOUND);
    }
}
