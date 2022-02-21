package racingcar.model.car;

import java.util.Objects;

import racingcar.util.MovableStrategy;

public class Car implements Comparable<Car> {
    private final Name name;
    private Position position;

    public Car(final String name) {
        this(name, Position.DEFAULT_POSITION);
    }

    public Car(final String name, final int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(final MovableStrategy movableStrategy) {
        if (movableStrategy.isMovable()) {
            position = position.increase();
        }
    }

    public boolean isInPosition(Position position) {
        return this.position.equals(position);
    }

    public int getPosition() {
        return position.value();
    }

    public String getName() {
        return name.value();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car)object;
        return name.equals(car.name);
    }

    @Override
    public int compareTo(Car car) {
        return position.compareTo(car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
