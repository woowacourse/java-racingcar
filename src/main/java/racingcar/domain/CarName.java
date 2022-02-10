package racingcar.domain;

public class CarName {
    private final String name;

    public CarName(String name) {
        validateNull(name);
        validateEmpty(name);
        validateBlank(name);
        validateNameLength(name);
        this.name = name;
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

    public String getName() {
        return name;
    }
}
