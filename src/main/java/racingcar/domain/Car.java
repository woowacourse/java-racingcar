package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int MOVE_BOUND = 4;

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void move(MoveValueStrategy moveValueStrategy) {
        if (moveValueStrategy.createMoveValue() >= MOVE_BOUND) {
            position = position.move();
        }
    }

    public int findMaxPosition(Position position) {
        return this.position.getMaxValue(position);
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
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