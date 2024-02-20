package racingcar.testCondition;

import racingcar.condition.MovingCarCondition;

public class FalseCondition implements MovingCarCondition {
    @Override
    public boolean isSatisfied() {
        return false;
    }
}
