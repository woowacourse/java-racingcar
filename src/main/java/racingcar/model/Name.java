package racingcar.model;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String MAX_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 이름은 5자 이하여야 합니다. ";

    private final String name;

    public Name(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (isNameLengthOverMax(name)) {
            throw new IllegalArgumentException(MAX_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private boolean isNameLengthOverMax(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    @Override
    public String toString() {
        return name;
    }
}
