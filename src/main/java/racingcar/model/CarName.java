package racingcar.model;

public class CarName {

    private static final int MIN_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        if (name.length() > MIN_LENGTH) {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
