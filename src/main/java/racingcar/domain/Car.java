package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int MOVE_BOUND = 4;

    private final Name name;
    private int position = 0;

    public Car(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    public void move(MoveValueStrategy moveValueStrategy) {
        if (moveValueStrategy.createMoveValue() >= MOVE_BOUND) {
            position++;
        }
    }

    public int findMaxPosition(int position) {
        return Math.max(this.position, position);
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}