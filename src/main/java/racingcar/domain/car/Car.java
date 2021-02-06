package racingcar.domain.car;

import racingcar.domain.rule.MoveCondition;

public class Car {
    private int position;
    private MoveCondition moveCondition;
    private CarName name;

    public Car(String name, MoveCondition moveCondition) {
        this.moveCondition = moveCondition;
        this.name = new CarName(name);
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

    public CarState getState() {
        return CarState.withNameAndPosition(this);
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Car)) {
            return false;
        }

        return name.equals(((Car) o).name);
    }
}
