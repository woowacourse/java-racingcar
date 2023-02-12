package domain;

import error.ErrorMessage;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.INVALID_NAME_LENGTH.getValue(), MAX_NAME_LENGTH)
            );
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
