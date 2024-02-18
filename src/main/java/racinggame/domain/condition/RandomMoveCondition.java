package racinggame.domain.condition;

import java.util.Random;
import racinggame.domain.MoveCondition;

public class RandomMoveCondition implements MoveCondition {

    private static final int MOVABLE_STANDARD = 4;
    private static final int RANDOM_BOUND = 10;

    private final Random randomGenerator;

    public RandomMoveCondition() {
        this.randomGenerator = new Random();
    }

    @Override
    public boolean isMovable() {
        return randomGenerator.nextInt(RANDOM_BOUND) >= MOVABLE_STANDARD;
    }
}
