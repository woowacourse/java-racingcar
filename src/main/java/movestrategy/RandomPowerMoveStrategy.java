package movestrategy;

import java.util.Random;

public class RandomPowerMoveStrategy implements MoveStrategy {

    private static final int MAXIMUM_POWER = 10;
    private static final int MINIMUM_POWER_TO_MOVE = 4;

    @Override
    public boolean isMovable() {
        Random random = new Random();
        int power = random.nextInt(MAXIMUM_POWER);
        return power >= MINIMUM_POWER_TO_MOVE;
    }
}
