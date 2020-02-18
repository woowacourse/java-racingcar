package racinggame.domain;

import racinggame.domain.car.movable.MovAbleStrategy;

public class TestMovableStrategy implements MovAbleStrategy {
    public boolean isMovable() {
        return true;
    }
}
