package vo;

import java.util.Objects;

public class CarName {
    public static final int MAX_NAME_LENGTH = 5;
    public static final String INVALID_NAME_LENGTH_EXCEPTION_MESSAGE = "5글자 까지만 가능합니다.";

    private final String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName of(String name) {
        validateName(name);
        return new CarName(name);
    }

    public String getValue() {
        return name;
    }

    private static void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName1 = (CarName) o;
        return name.equals(carName1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
