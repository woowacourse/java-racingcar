package racingcar.domain;

import static racingcar.exception.ExceptionMessage.*;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.dto.CarStatus;

public class Car implements Comparable<Car> {
    private static final Pattern NAME_PATTERN = Pattern.compile("[^ㄱ-ㅎ가-힣a-zA-Z0-9_-]");
    private static final int MAX_NAME_LENGTH = 5;
    private static final int CAR_MOVE_THRESHOLD = 4;

    private final String name;
    private int position = 0;

    public Car(final String name) {
        validateName(name);
        this.name = name.trim();
    }

    private void validateName(final String name) {
        validateNotNull(name);
        validateNameStyle(name);
        validateNameLength(name);
    }

    private void validateNotNull(final String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(NOT_NULL_CAR_NAME.getMessage());
        }
    }

    private void validateNameStyle(final String name) {
        Matcher matcher = NAME_PATTERN.matcher(name);

        if (matcher.find()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
        }
    }

    private void validateNameLength(final String name) {
        if (name.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_SIZE.getMessage());
        }
    }

    public void move(final int threshold) {
        if (threshold >= CAR_MOVE_THRESHOLD) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public CarStatus getCarStatus() {
        return new CarStatus(name, position);
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
