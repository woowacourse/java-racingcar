package racinggame.domain.condition;

import java.util.Random;
import racinggame.domain.MoveCondition;

public class RandomMoveCondition implements MoveCondition {

    private static final int MOVABLE_STANDARD = 4;
    private static final int RANDOM_BOUND = 10;
    private static final Random RANDOM = new Random();

    @Override
    public boolean isMovable() {
        return RANDOM.nextInt(RANDOM_BOUND) >= MOVABLE_STANDARD;
    }
}
