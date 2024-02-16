package domain;

import exception.EmptyCarNameException;
import exception.MaxCarNameLengthException;
import exception.SpecialCharacterCarNameException;
import java.util.Objects;
import java.util.regex.Pattern;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_FORWARD_LOWER_BOUND = 3;
    private static final Pattern FIND_SPECIAL_CHARACTER_PATTERN = Pattern.compile("[ !@#$%^&*().?\":{}|<>]");

    private final String name;
    private int distance = 0;

    public Car(final String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(final String name) {
        emptyNameValidation(name);
        overMaxLengthValidation(name);
        specialCharacterProhibitValidation(name);
    }

    private void emptyNameValidation(final String name) {
        if (name == null || name.isBlank()) {
            throw new EmptyCarNameException();
        }
    }

    private void overMaxLengthValidation(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new MaxCarNameLengthException(name, MAX_NAME_LENGTH);
        }
    }

    private void specialCharacterProhibitValidation(final String name) {
        if (FIND_SPECIAL_CHARACTER_PATTERN.matcher(name).find()) {
            String invalidCharacter = FIND_SPECIAL_CHARACTER_PATTERN.matcher(name).group();
            throw new SpecialCharacterCarNameException(name, invalidCharacter);
        }
    }

    public void moveForward(final int condition) {
        if (condition > MOVE_FORWARD_LOWER_BOUND) {
            distance++;
        }
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
