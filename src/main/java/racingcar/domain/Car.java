package racingcar.domain;

import java.util.Objects;

/**
 * 자동차 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/13
 */
public class Car {
    public static final int MIN_MOVE_POWER = 4;

    private final Name name;
    private Position position;

    public Car(final Name name) {
        this(name, new Position());
    }

    public Car(final Name name, final Position position) {
        this.name = Objects.requireNonNull(name);
        this.position = position;
    }

    public void move(final int power) {
        if (power >= MIN_MOVE_POWER) {
            position.moveForward();
        }
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

    public boolean isPositionOf(final int position) {
        return this.position.isPositionOf(position);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
