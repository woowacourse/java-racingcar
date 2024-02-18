package racingcar.model;

import java.util.Objects;

public class CarName {

    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private final String name;

    public CarName(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (isNameEmpty(name) || name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            String message = "자동차 이름이 1-" + MAXIMUM_CAR_NAME_LENGTH
                    + "자 사이의 길이로 입력되지 않았습니다. " + "입력값 : " + name;
            throw new IllegalArgumentException(message);
        }
    }

    private boolean isNameEmpty(String name) {
        return name == null || name.isEmpty();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final CarName carName = (CarName) obj;
        return this.name.equals(carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "CarName{" +
                "name=" + name +
                "}";
    }
}
