package racingcar.domain;

import static racingcar.util.Constant.CAR_MOVE_THRESHOLD;
import static racingcar.util.Constant.MAX_NAME_LENGTH;
import static racingcar.exception.ExceptionMessage.*;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car implements Comparable<Car> {
    private static final String CAR_POSITION_SYMBOL = "-";

    private final String name;
    private int position = 0;

    public Car(final String name) {
        validateNotNull(name);
        String trimmedName = name.trim();
        validateName(trimmedName);
        this.name = trimmedName;
    }

    private void validateName(final String name) {
        validateNameStyle(name);
        validateNameLength(name);
    }

    private void validateNotNull(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(NOT_NULL_CAR_NAME.getMessage());
        }
    }

    private void validateNameStyle(final String name) {
        final String regex = "[^a-zA-Z0-9_-]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);

        if (matcher.find()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_SIZE.getMessage());
        }
    }

    public void move(final int threshold) {
        if (threshold >= CAR_MOVE_THRESHOLD.getValue()) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
