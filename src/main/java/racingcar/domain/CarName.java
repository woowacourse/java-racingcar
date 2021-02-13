package racingcar.domain;

import java.util.Objects;

public class CarName {

    public static final int MINIMUM_CAR_NAME_LENGTH = 1;
    public static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    private final String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName from(String name) {
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
            throw new RuntimeException();
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() < MINIMUM_CAR_NAME_LENGTH || MAXIMUM_CAR_NAME_LENGTH < name.length()) {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return name;
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
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
