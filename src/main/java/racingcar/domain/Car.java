package racingcar.domain;

import java.util.Objects;

public class Car {

    public static final int DRIVE_MINIMUM_VALUE = 0;
    public static final int DRIVE_MAXIMUM_VALUE = 9;
    public static final int DRIVE_BOUNDARY = 4;

    private Integer position;
    private final CarName name;

    public Car(final CarName name, final int position) {
        this.position = position;
        this.name = name;
    }

    public Car(final CarName name) {
        this(name, 1);
    }

    public static Car from(String name) {
        return new Car(CarName.from(name));
    }

    public void drive(final int value) {
        if (value < DRIVE_MINIMUM_VALUE || DRIVE_MAXIMUM_VALUE < value) {
            throw new RuntimeException("");
        }

        if (DRIVE_BOUNDARY <= value) {
            moveForward();
        }
    }

    private void moveForward() {
        position++;
    }

    public String getName() {
        return name.toString();
    }

    public int getPosition() {
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
        return Objects.equals(position, car.position) && Objects
                .equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
