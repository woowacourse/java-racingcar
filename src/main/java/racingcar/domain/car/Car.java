package racingcar.domain.car;

import racingcar.domain.rule.MoveCondition;
import racingcar.exception.MoveConditionOutOfBoundException;

public class Car {
    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 9;
    private static final int MOVE_THRESHOLD = 4;

    private int position;
    private MoveCondition<Integer> moveCondition;
    private CarName name;

    public Car(String name, MoveCondition moveCondition) {
        this.moveCondition = moveCondition;
        this.name = new CarName(name);
    }

    public void move() {
        if (!isMovable()) {
            return;
        }

        position++;
    }

    private boolean isMovable() {
        return moveCondition.generate(MAX_BOUND) >= MOVE_THRESHOLD;
    }

    public int getPosition() {
        return position;
    }

    public CarName getName() {
        return name;
    }

    public CarState getState() {
        return CarState.valueOf(this);
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