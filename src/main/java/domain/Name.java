package domain;

import constant.ExceptionMessage;

import java.util.Objects;

public class Name {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String name;

    public Name (String name) {
        name = name.trim();
        validCarName(name);
        this.name = name;
    }

    private void validCarName(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    ExceptionMessage.CAR_NAME_WRONG_LENGTH_MESSAGE.getExceptionMessage());
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException(
                    ExceptionMessage.CAR_NAME_BLANK_MESSAGE.getExceptionMessage());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Name) {
            return name.equals(((Name) obj).name);
        }

        return false;
    }
}
