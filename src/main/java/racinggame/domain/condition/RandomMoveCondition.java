package racinggame.domain.condition;

import java.util.Random;
import racinggame.domain.MoveCondition;

public class RandomMoveCondition implements MoveCondition {

    private static final Random random = new Random();

    @Override
    public boolean isMovable() {
        return random.nextInt(10) >= 4;
    }
}
