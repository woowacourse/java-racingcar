package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int STOP_MIN_NUMBER = 0;
    private static final int STOP_MAX_NUMBER = 3;
    private static final int MOVE_FORWARD_MIN_NUMBER = 4;
    private static final int MOVE_FORWARD_MAX_NUMBER = 9;

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void move(int powerValue) {
        if (MOVE_FORWARD_MIN_NUMBER <= powerValue && powerValue <= MOVE_FORWARD_MAX_NUMBER) {
            position.moveForward();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
