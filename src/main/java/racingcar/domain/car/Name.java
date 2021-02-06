package racingcar.domain.car;

public class Name {

    private static final String BLANK = " ";
    private static final int MINIMUM_LENGTH = 1;
    private static final int MAXIMUM_LENGTH = 5;

    private final String name;

    Name(final String name) {
        validateBlank(name);
        validateLength(name);
        this.name = name;
    }

    private void validateBlank(final String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLength(final String name) {
        if (name.length() < MINIMUM_LENGTH || MAXIMUM_LENGTH < name.length()) {
            throw new IllegalArgumentException();
        }
    }

    public String toString() {
        return name;
    }

}
