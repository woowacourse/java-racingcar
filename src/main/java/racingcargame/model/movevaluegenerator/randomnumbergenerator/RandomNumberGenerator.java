package racingcargame.model.movevaluegenerator.randomnumbergenerator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final Random random = new Random();

    @Override
    public int generateNumber(final int boundaryNumber) {
        return random.nextInt(boundaryNumber);
    }
}
