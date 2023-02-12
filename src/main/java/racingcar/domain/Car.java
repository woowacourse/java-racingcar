package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int STOP_MIN_NUMBER = 0;
    private static final int STOP_MAX_NUMBER = 3;
    private static final int MOVE_FORWARD_MIN_NUMBER = 4;
    private static final int MOVE_FORWARD_MAX_NUMBER = 9;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int powerValue) {
        position += decideMovingValue(powerValue);
    }

    private int decideMovingValue(int powerValue) {
        if (STOP_MIN_NUMBER <= powerValue && powerValue <= STOP_MAX_NUMBER) {
            return 0;
        }
        if (MOVE_FORWARD_MIN_NUMBER <= powerValue && powerValue <= MOVE_FORWARD_MAX_NUMBER) {
            return 1;
        }
        return 0;
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
