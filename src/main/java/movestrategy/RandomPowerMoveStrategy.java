package movestrategy;

import static constant.Numbers.MOVE_BOUNDARY_NUMBER;
import static constant.Numbers.RANDOM_NUMBER_RANGE;

import java.util.Random;

public class RandomPowerMoveStrategy implements MoveStrategy {

    @Override
    public boolean isMovable() {
        Random random = new Random();
        int power = random.nextInt(RANDOM_NUMBER_RANGE);
        return power >= MOVE_BOUNDARY_NUMBER;
    }
}
