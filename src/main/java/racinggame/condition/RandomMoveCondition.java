package racinggame.condition;

import java.util.Random;
import racinggame.MoveCondition;

public class RandomMoveCondition implements MoveCondition {

    private static final Random random = new Random();

    @Override
    public boolean isMovable() {
        return random.nextInt(10) >= 4;
    }
}
