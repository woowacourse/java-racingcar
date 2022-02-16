package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int INIT_POSITION = 1;
    public static final int SAME_POSITION_NUMBER = 0;

    private Position position = new Position(INIT_POSITION);
    private final CarName name;

    public Car(final CarName name) {
        checkNull(name);
        this.name = name;
    }

    private void checkNull(CarName name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차의 이름은 null이 될수 없습니다.");
        }
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public int compareTo(final Car other) {
        return position.compareTo(other.getPosition());
    }

    public boolean isSamePositionWith(final Car other) {
        return compareTo(other) == SAME_POSITION_NUMBER;
    }

    public CarName getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        Car car = (Car)other;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void attemptToMove(final boolean canMove) {
        if (canMove) {
            this.position = position.move();
        }
    }
}
