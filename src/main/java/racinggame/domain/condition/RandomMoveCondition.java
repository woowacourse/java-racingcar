package racinggame.domain.condition;

import java.util.Random;
import racinggame.domain.MoveCondition;

public class RandomMoveCondition implements MoveCondition {

    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;
    private static final int THRESHOLD = 4;

    @Override
    public boolean isMovable() {
        return RANDOM.nextInt(BOUND) >= THRESHOLD;
    }
}
