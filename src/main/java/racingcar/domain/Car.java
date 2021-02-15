package racingcar.domain;

import racingcar.domain.movingstrategy.MovingStrategy;
import racingcar.domain.movingstrategy.RandomMovingStrategy;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final Name name;
    private final Position position;
    private final MovingStrategy movingStrategy;

    public Car(final Name name) {
        this(name, Position.START);
    }

    public Car(final Name name, final Position position) {
        this(name, position, RandomMovingStrategy.getInstance());
    }

    public Car(final Name name, final Position position, final MovingStrategy movingStrategy) {
        this.name = name;
        this.position = position;
        this.movingStrategy = movingStrategy;
    }

    public Car moveDefinitely() {
        final Position nextPosition = position.move();
        return new Car(name, nextPosition);
    }

    public Car move() {
        return movingStrategy.move(this);
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    @Override
    public int compareTo(Car o) {
        return position.compareTo(o.position);
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

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                ", movingStrategy=" + movingStrategy +
                '}';
    }
}
