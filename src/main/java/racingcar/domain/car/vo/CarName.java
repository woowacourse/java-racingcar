package racingcar.domain.car.vo;

import java.util.Objects;

public class CarName {
    private static final String LONGER_THAN_FIVE_CAR_NAME = "자동차 이름은 최대 5자입니다.";
    private static final String BLANK_CAR_NAME = "공백으로만 이루어진 자동차 이름이 있습니다.";
    private static final String CAR_NAME_NULL_EXCEPTION = "자동차 이름에 null이 들어왔습니다.";
    private static final int MAX_LENGTH_OF_CAR_NAME = 5;

    private final String name;

    private CarName(final String value) {
        this.name = value;
    }

    public static CarName valueOf(final String value) {
        validateBlank(value);
        validateLength(value);
        return new CarName(value);
    }

    private static void validateLength(final String value) {
        if (value.length() > MAX_LENGTH_OF_CAR_NAME) {
            throw new IllegalArgumentException(LONGER_THAN_FIVE_CAR_NAME);
        }
    }

    private static void validateBlank(final String value) {
        if (value == null) {
            throw new NullPointerException(CAR_NAME_NULL_EXCEPTION);
        }
        if (value.isBlank()) {
            throw new IllegalArgumentException(BLANK_CAR_NAME);
        }
    }

    public String getCarName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
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
