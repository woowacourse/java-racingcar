package racingcar.domain;

import racingcar.utils.ExceptionMessage;

import java.util.Objects;

public class CarName {
    private static final int MAX_LENGTH_OF_CAR_NAME = 5;
    private final String value;

    public CarName(String value) {
        validateLength(value);
        validateBlank(value);
        this.value = value;
    }

    private void validateLength(String value) {
        if (value.length() > MAX_LENGTH_OF_CAR_NAME) {
            throw new IllegalArgumentException(ExceptionMessage.LONGER_THAN_FIVE_CAR_NAME);
        }
    }

    private void validateBlank(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK_CAR_NAME);
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
