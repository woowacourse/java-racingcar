package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int CONDITION = 4;

    private final CarName carName;
    private Position position = Position.ZERO;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public void moveForwardByNumber(int number) {
        if (number >= CONDITION) {
            this.position = position.moveForward();
        }
    }

    public boolean isSamePosition(int position) {
        return this.position.isSamePosition(position);
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public String getName() {
        return carName.getCarName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
