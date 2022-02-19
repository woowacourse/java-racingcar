package racingcar.domain.car.strategy;

import java.util.Iterator;
import java.util.List;

public class CustomMoveStrategy implements MoveStrategy {

    private Iterator<Boolean> conditions;

    public CustomMoveStrategy() {
    }

    public CustomMoveStrategy(final List<Boolean> conditions) {
        initMoveConditions(conditions);
    }

    public void initMoveConditions(final List<Boolean> conditions) {
        this.conditions = conditions.iterator();
    }

    @Override
    public boolean isMovable() {
        return conditions.next();
    }

}
