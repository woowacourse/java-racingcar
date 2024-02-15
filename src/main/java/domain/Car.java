package domain;

import static domain.ExceptionMessages.EMPTY_CAR_NAME_EXCEPTION;
import static domain.ExceptionMessages.SPECIAL_CHARACTER_CAR_NAME_EXCEPTION;
import static domain.ExceptionMessages.TOO_LONG_CAR_NAME_EXCEPTION;

import java.util.Objects;
import java.util.regex.Pattern;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int distance = 0;

    public Car(final String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME_EXCEPTION.getMessage());
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(TOO_LONG_CAR_NAME_EXCEPTION.getMessage());
        }
        Pattern pattern = Pattern.compile("[ !@#$%^&*().?\":{}|<>]");
        if (pattern.matcher(name).find()) {
            throw new IllegalArgumentException(SPECIAL_CHARACTER_CAR_NAME_EXCEPTION.getMessage());
        }
    }

    public void moveForward() {
        distance++;
    }

    public String getCarName() {
        return this.name;
    }

    public Integer getDistance() {
        return this.distance;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car) object;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
