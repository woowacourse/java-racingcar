package racingcar;

import static racingcar.Rule.MOVE_FORWARD_BOUNDARY;
import static racingcar.Rule.DRIVE_MAXIMUM_VALUE;
import static racingcar.Rule.DRIVE_MINIMUM_VALUE;

public class Car {

    public static final int MINIMUM_CAR_NAME_LENGTH = 1;
    public static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private Integer position;
    private final String name;

    private Car(final String name) {
        this.position = 1;
        this.name = name;
    }

    public static Car from(String name) {
        name = name.trim();
        validateName(name);
        return new Car(name);
    }

    public void drive(final int value) {
        if (value < DRIVE_MINIMUM_VALUE || DRIVE_MAXIMUM_VALUE < value) {
            throw new RuntimeException();
        }

        if (value >= MOVE_FORWARD_BOUNDARY) {
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
    public int hashCode() {
        int result = 17;
        result = 31 * result + position.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Car) {
            Car car = (Car) obj;
            return this.name.equals((car).name) && this.position.equals((car).position);
        }
        return false;
    }
}
