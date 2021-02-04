package racingcar.domain.car;

import racingcar.domain.rule.Condition;

public class Car {

    private int position;
    private Condition moveCondition;

    public Car(Condition moveCondition) {
        this.moveCondition = moveCondition;
    }

    public void move() {
        if (!moveCondition.isMovable()) {
            return;
        }

        position++;
    }

    public int getPosition() {
        return position;
    }
}
