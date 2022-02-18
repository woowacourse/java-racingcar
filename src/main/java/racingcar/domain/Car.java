package racingcar.domain;

import racingcar.domain.movestrategy.MovingStrategy;

public class Car {

    private final Name name;
    private int position;

    public Car(final String name) {
        this.name = new Name(name);
        position = 0;
    }

    public Car(final String name, final int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(MovingStrategy movingStrategy) {
        if (movingStrategy.canMoveForward()) {
            position++;
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}
