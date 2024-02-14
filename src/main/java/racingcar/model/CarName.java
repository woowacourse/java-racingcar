package racingcar.model;

public class CarName {

    private static final int MIN_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (name.length() > MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
