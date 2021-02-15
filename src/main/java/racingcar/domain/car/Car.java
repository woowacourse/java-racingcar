package racingcar.domain.car;

import java.util.Objects;

public class Car implements Comparable<Car> {

    public static final int MOVE_CONDITION = 4;

    private final Name name;
    private Position position;

    private Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public Car(final String name) {
        this(new Name(name), Position.ZERO);
    }

    public Car(final Name name) {
        this(name, Position.ZERO);
    }

    public void move(final int conditionNumber) {
        if (conditionNumber >= MOVE_CONDITION) {
            position = position.move();
        }
    }

    public boolean inSamePosition(final Car car) {
        return this.compareTo(car) == 0;
    }

    public String getName() {
        return name.getLiteral();
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Car o) {
        return this.position.compareTo(o.position);
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
