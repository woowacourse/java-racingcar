package racingcar.condition;

public class FalseCondition implements MovingCarCondition {
    @Override
    public boolean isSatisfied() {
        return false;
    }
}
