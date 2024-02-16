package racinggame.domain.condition;

import java.util.Random;
import racinggame.domain.MoveCondition;

public class RandomMoveCondition implements MoveCondition {

    private static final Random RANDOM = new Random();

    @Override
    public boolean isMovable() {
        return RANDOM.nextInt(10) >= 4;
    }
}
