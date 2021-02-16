package racingcar.domain;

import java.util.Objects;

public class CarName {

    public static final int MINIMUM_CAR_NAME_LENGTH = 1;
    public static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private final String value;

    private CarName(String name) {
        this.value = name;
    }

    public static CarName valueOf(String name) {
        name = name.trim();
        validateName(name);

        return new CarName(name);
    }

    private static void validateName(String name) {
        validateNameLength(name);
        validateNameNullOrEmpty(name);
    }

    private static void validateNameNullOrEmpty(String name) {
        if (name == null || "".equals(name)) {
            throw new RuntimeException("이름은 1자 이상, 5자 이하");
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() < MINIMUM_CAR_NAME_LENGTH || MAXIMUM_CAR_NAME_LENGTH < name.length()) {
            throw new RuntimeException("이름은 1자 이상, 5자 이하");
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CarName carName = (CarName) obj;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
