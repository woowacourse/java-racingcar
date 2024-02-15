package racingcar.domain;

import static racingcar.exception.ExceptionMessage.*;

public class Car implements Comparable<Car> {
    private static final String CAR_POSITION_SYMBOL = "-";

    private final String name;
    private int position = 0;

    public Car(final String name) {
        validateName(name);
        this.name = name.trim();
    }

    private void validateName(final String name) {
        validateNotNull(name);
        validateNameStyle(name);
        validateNameSize(name);
    }

    private void validateNotNull(final String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(NOT_NULL_CAR_NAME.getMessage());
        }
    }

    private void validateNameStyle(final String name) {
        final String regex = "^[a-zA-Z0-9_-]";
        if (!name.matches(regex)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
        }
    }

    private void validateNameSize(final String name) {
        if (name.trim().length() > 5) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_SIZE.getMessage());
        }
    }

    public void move(final int threshold) {
        if (threshold >= 4) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String result() {
        return name + " : " + CAR_POSITION_SYMBOL.repeat(position);
    }

    public int compareTo(Car other) {
        return this.position - other.position;
    }

    public boolean isSamePosition(Car other) {
        return this.position == other.position;
    }
}
