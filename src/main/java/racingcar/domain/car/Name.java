package racingcar.domain.car;

public class Name {
    public static final String BLANK = " ";
    public static final int MINIMUM_LENGTH = 1;
    public static final int MAXIMUM_LENGTH = 5;

    private final String name;

    Name(String name) {
        validateBlank(name);
        validateLength(name);
        this.name = name;
    }

    private void validateBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLength(String name) {
        if (name.length() < MINIMUM_LENGTH || MAXIMUM_LENGTH < name.length()) {
            throw new IllegalArgumentException();
        }
    }

    public String toString() {
        return name;
    }
}
