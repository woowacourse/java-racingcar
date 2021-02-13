package racingcar.domain;

import static racingcar.domain.RacingGameRule.DRIVE_BOUNDARY;
import static racingcar.domain.RacingGameRule.DRIVE_MAXIMUM_VALUE;
import static racingcar.domain.RacingGameRule.DRIVE_MINIMUM_VALUE;

import java.util.Objects;

public class Car {

    public static final int MINIMUM_CAR_NAME_LENGTH = 1;
    public static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private Integer position;
    private final String name;

    public Car(final String name, final int position) {
        this.position = position;
        this.name = name;
    }

    public Car(final String name) {
        this(name, 1);
    }

    public static Car from(String name) {
        name = name.trim();
        validateName(name);
        return new Car(name);
    }

    public void drive(final int value) {
        if (value < DRIVE_MINIMUM_VALUE || DRIVE_MAXIMUM_VALUE < value) {
            throw new RuntimeException("");
        }

        if (DRIVE_BOUNDARY <= value) {
            moveForward();
        }
    }

    private static void validateName(String name) {
        validateNameLength(name);
        validateNameNullOrEmpty(name);
    }

    private static void validateNameNullOrEmpty(String name) {
        if (name == null || "".equals(name)) {
            throw new RuntimeException();
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() < MINIMUM_CAR_NAME_LENGTH || MAXIMUM_CAR_NAME_LENGTH < name.length()) {
            throw new RuntimeException();
        }
    }

    private void moveForward() {
        position++;
    }

    public String getName() {
        return name;
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
