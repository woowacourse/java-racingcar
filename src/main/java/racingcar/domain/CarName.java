package racingcar.domain;

import racingcar.utils.ExceptionMessage;

import java.util.Objects;

public class CarName {
    private static final int MAX_LENGTH_OF_CAR_NAME = 5;

    private final String name;

    public CarName(String value) {
        validateCarName(value);
        this.name = value;
    }

    private void validateCarName(String value) {
        if (value == null){
            throw new NullPointerException(ExceptionMessage.NULL_CAR_NAME);
        }

        if (value.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK_CAR_NAME);
        }

        if (value.length() > MAX_LENGTH_OF_CAR_NAME) {
            throw new IllegalArgumentException(ExceptionMessage.LONGER_THAN_FIVE_CAR_NAME);
        }
    }

    public String value() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
