package model;

import common.Exception;

import java.util.Objects;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validateNullAndEmpty(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateNullAndEmpty(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException(Exception.CAR_NAME_NULL_BLANK.getMessage());
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(Exception.CAR_NAME_LENGTH.getMessage());
        }
    }

    public String getName() {
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
