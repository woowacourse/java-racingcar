package racingcar.domain.car;

import racingcar.domain.game.CarState;
import racingcar.domain.rule.Condition;

public class Car {

    private int position;
    private Condition moveCondition;
    private CarName name;

    public Car(CarName name, Condition moveCondition) {
        this.moveCondition = moveCondition;
        this.name = name;
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

    public CarName getName() {
        return name;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public CarState getState() {
        return CarState.withNameAndPosition(name, position);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Car)) {
            return false;
        }

        return name.equals(((Car) o).name);
    }
}
