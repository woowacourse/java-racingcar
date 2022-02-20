package racingcargame.model.numbergenerator;

import java.util.Random;
import racingcargame.model.numbergenerator.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {
    private final Random random = new Random();

    @Override
    public int generateNumber(final int boundaryNumber) {
        return random.nextInt(boundaryNumber);
    }
}
