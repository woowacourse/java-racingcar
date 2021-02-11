package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int CONDITION = 4;

    private final CarName carName;
    private int position = 0;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public void moveForwardByNumber(int number) {
        if (number >= CONDITION) {
            position++;
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
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
