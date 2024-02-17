package racingcar.domain;

import racingcar.exception.InvalidNameLengthException;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public Name(final String value) {
        validateName(value);
        this.value = value;
    }

    private void validateName(final String value) {
        validateNameNotNull(value);
        validateNameLength(value);
        validateNameNotBlank(value);
    }

    private void validateNameLength(final String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new InvalidNameLengthException();
        }
    }

    private void validateNameNotBlank(final String value) {
        if (value.isBlank()) {
            throw new InvalidNameLengthException();
        }
    }

    private void validateNameNotNull(final String value) {
        if (value == null) {
            throw new InvalidNameLengthException();
        }
    }

    public String getValue() {
        return value;
    }
}
