package racingcar.domain.random;

import java.util.Random;

public class RacingcarRandomNumberGenerator implements RandomNumberGenerator {

    private static final int UPPER_BOUNDARY = 10;
    private static final int FORWARD_BOUNDARY_NUMBER = 4;

    private final Random random = new Random();

    @Override
    public boolean isMoveAvailable() {
        return random.nextInt(UPPER_BOUNDARY) >= FORWARD_BOUNDARY_NUMBER;
    }
}
