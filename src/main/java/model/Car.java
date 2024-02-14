package model;

import java.lang.runtime.ObjectMethods;
import java.util.Objects;

public class Car {
    private String name;
    public Car(String name) {
        validateNullAndEmpty(name);
        validateNameLength(name);

        this.name = name;
    }

    private void validateNullAndEmpty(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
