import domain.MovingPolicy;

import java.util.Random;

public class RandomMovingPolicy implements MovingPolicy {
    private static final int UPPER_BOUND_EXCLUSIVE = 10;
    private static final Random random = new Random();

    @Override
    public int decide() {
        return random.nextInt(UPPER_BOUND_EXCLUSIVE);
    }
}
