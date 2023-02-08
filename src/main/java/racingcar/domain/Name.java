package racingcar.domain;

public class Name {

    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 0;

    private final String name;
    public Name(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (name.length() > MAX_LENGTH || name.length() == MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}