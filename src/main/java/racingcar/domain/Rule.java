package racingcar.domain;

import racingcar.domain.movement.MovementStrategy;

public class Rule {

    private final MovementStrategy strategy;

    public Rule(MovementStrategy strategy) {
        this.strategy = strategy;
    }

    public MovementStrategy getMovementStrategy() {
        return strategy;
    }
}
