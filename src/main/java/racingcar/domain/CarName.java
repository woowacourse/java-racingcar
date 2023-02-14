package racingcar.domain;

import java.util.Objects;

public class CarName {
    private static final int CAR_NAME_MINIMUM_LENGTH = 1;
    private static final int CAR_NAME_MAXIMUM_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validateLengthOfCarName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateLengthOfCarName(String name) {
        if (name.length() > CAR_NAME_MAXIMUM_LENGTH || name.length() < CAR_NAME_MINIMUM_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 길이는 1이상 5이하여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName n = (CarName) o;
        return Objects.equals(name, n.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
