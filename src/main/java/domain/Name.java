package domain;

import error.ErrorMessage;

public class Name {
    private final String name;

    private Name(String name) {
        validate(name);
        this.name = name;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    private void validate(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH.getValue());
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
