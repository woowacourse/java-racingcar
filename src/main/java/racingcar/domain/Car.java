package racingcar.domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validateNull(name);
        validateEmpty(name);
        validateBlank(name);
        validateNameLength(name);
        this.name = name;
        this.position = 0;
    }

    private void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
