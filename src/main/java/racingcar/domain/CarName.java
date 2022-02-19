package racingcar.domain;

import java.util.Objects;

public class CarName {
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;

    private final String name;

    public CarName(final String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("null은 사용할 수 없습니다. String 타입을 사용하세요.");
        }
        checkName(name);
        this.name = name;
    }

    private void checkName(final String name) {
        checkBlank(name);
        checkMinimumCarName(name);
        checkMaximumCarNameLength(name);
    }

    private void checkBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름을 입력해주세요!");
        }
    }

    private void checkMinimumCarName(final String name) {
        if (name.length() < MINIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MINIMUM_CAR_NAME_LENGTH + "글자 이상이여야 합니다.");
        }
    }

    private void checkMaximumCarNameLength(final String name) {
        if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름 길이는 " + MAXIMUM_CAR_NAME_LENGTH + " 글자 이하여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        CarName carName = (CarName) other;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
