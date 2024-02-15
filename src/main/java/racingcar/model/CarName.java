package racingcar.model;

public class CarName {

    private static final int MIN_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    private void validate(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (name.trim().length() > MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
    }


}
