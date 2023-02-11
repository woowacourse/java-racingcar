package racingcar.domain;

import static racingcar.domain.Car.Validator.*;
import static racingcar.exception.ExceptionMessage.BLANK_CAR_NAME;
import static racingcar.exception.ExceptionMessage.OUT_OF_CAR_NAME_LENGTH;

import java.util.Objects;

public class Car {
    private final Name name;
    private final Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validateBlankCarName(name);
        validateCarNameLength(name);
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public static class Validator {
        private static final int MAX_NAME_LENGTH = 6;

        private Validator() {
        }

        public static void validateBlankCarName(String name) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException(BLANK_CAR_NAME.getMessage());
            }
        }

        public static void validateCarNameLength(String name) {
            if (name.length() >= MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(OUT_OF_CAR_NAME_LENGTH.getMessage());
            }
        }
    }

    public void move() {
        position.forward();
    }

    public boolean isSamePosition(Position position) {
        return Objects.equals(this.position, position);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
