package model;

public class Car {
    private final String name;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 공백 포함 5자 이하여야 한다.");
        }
    }
}
