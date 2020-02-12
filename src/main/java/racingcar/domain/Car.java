package racingcar.domain;

import java.util.Objects;

public class Car {
    public static final int START_POSITION = 1;
    public static final int MIN_MOVE_POWER = 4;

    private final Name name;
    private int position;

    public Car(final Name name) {
        this.name = Objects.requireNonNull(name);
        this.position = START_POSITION;
    }

    public void move(final int power) {
        if(power>=MIN_MOVE_POWER) {
            position++;
        }
    }

    public boolean isEqualPositionTo(int position) {
        return this.position == position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
