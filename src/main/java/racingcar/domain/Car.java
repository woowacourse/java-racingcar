package racingcar.domain;

import static racingcar.domain.Car.Validator.*;
import static racingcar.exception.ExceptionMessage.BLANK_CAR_NAME;
import static racingcar.exception.ExceptionMessage.OUT_OF_CAR_NAME_LENGTH;

import java.util.Objects;
import racingcar.dto.RacingCarStatusResponse;

public class Car {
    private final String name;
    private final Position position;

    public Car(String name) {
        validateBlankCarName(name);
        validateCarNameLength(name);
        this.name = name;
        this.position = new Position(0);
    }

    public static class Validator {
        private static final int MAX_NAME_LENGTH = 6;

        private Validator() {
        }

        public static void validateBlankCarName(String name) {
            if (name.isBlank()) {
                throw new IllegalArgumentException(BLANK_CAR_NAME.getMessage());
            }
        }

        public static void validateCarNameLength(String name) {
            if (name.length() >= MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(OUT_OF_CAR_NAME_LENGTH.getMessage());
            }
        }
    }

    public RacingCarStatusResponse getStatus() {
        return new RacingCarStatusResponse(name, position.getValue());
    }

    public void move() {
        position.forward();
    }

    public Position getMovedLength() {
        return position;
    }

    public boolean isSamePosition(Position position) {
        return Objects.equals(this.position, position);
    }
}
