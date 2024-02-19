package racingcar.testCondition;

import racingcar.condition.MovingCarCondition;

public class TrueCondition implements MovingCarCondition {
    @Override
    public boolean isSatisfied() {
        return true;
    }
}
