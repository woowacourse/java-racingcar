package racinggame.domain.condition;

import racinggame.domain.MoveCondition;

public class FixedMoveCondition implements MoveCondition {

    @Override
    public boolean isMovable() {
        return true;
    }
}
