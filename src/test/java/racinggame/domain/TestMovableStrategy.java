package racinggame.domain;

import racinggame.domain.car.generatenumber.MovAbleStrategy;

public class TestMovableStrategy implements MovAbleStrategy {
    public boolean isMovable() {
        return true;
    }
}
