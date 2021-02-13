package racingcar.domain.car;

import java.util.Objects;

public class Car {

    private static final int START_POSITION = 0;

    private final Name name;
    private Position position;

    public Car(final String name) {
        this(name, START_POSITION);
    }

    public Car(final String name, final int position) {
        this.name = new Name(name);
        this.position = Position.valueOf(position);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void move(final int randomNumber) {
        position = position.addPosition(randomNumber);
    }

    public boolean isEqualPosition(final int value) {
        return position.isEqualNumber(value);
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
        return Objects.equals(name, car.name) && Objects
            .equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}