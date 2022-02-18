package racingcar.domain;

import java.util.Objects;

import racingcar.validator.RacingCarValidator;

public class Car {
    private static final int POSITION_INIT = 0;

    private final String name;
    private int position;

    public Car(String name) {
        RacingCarValidator.validateCarName(name);
        this.name = name;
        this.position = POSITION_INIT;
    }

    public void move(MovingPolicy movingPolicy) {
        if (movingPolicy.isMovable()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Car car = (Car)o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
