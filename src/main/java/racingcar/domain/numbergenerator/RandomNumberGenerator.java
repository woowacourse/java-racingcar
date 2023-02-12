package racingcar.domain.numbergenerator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{

    private static final int BOUND = 10;

    @Override
    public int generateNumber() {
        Random random = new Random();
        return random.nextInt(BOUND);
    }
}
