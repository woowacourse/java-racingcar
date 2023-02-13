package model;

import exception.ErrorCode;

public class Name {

    private static final int MIN_NAME = 1;
    private static final int MAX_NAME = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (isNameLengthInRange(name.length())) {
            return;
        }
        throw new IllegalArgumentException(
            String.format(ErrorCode.CAR_NAME_OUT_OF_RANGE.getMessage(), MIN_NAME,
                MAX_NAME));
    }

    private boolean isNameLengthInRange(final int nameLength) {
        return nameLength >= MIN_NAME && nameLength <= MAX_NAME;
    }

    public String getName() {
        return name;
    }
}
