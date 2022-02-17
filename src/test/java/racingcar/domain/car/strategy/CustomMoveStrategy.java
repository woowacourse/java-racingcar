package racingcar.domain.car.strategy;

import java.util.Iterator;
import java.util.List;

public class CustomMoveStrategy implements MoveStrategy {

    private final Iterator<Boolean> conditions;

    public CustomMoveStrategy(final List<Boolean> conditions) {
        this.conditions = conditions.iterator();
    }

    @Override
    public boolean isPossibleToMove() {
        return conditions.next();
    }

}
