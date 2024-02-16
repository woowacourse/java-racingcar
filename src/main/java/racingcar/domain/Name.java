package racingcar.domain;

import racingcar.exception.InvalidNameLengthException;

public class Name {

    private static final int MAX_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validateName(value);
        this.value = value;
    }

    private void validateName(String value) {
        validateNameLength(value);
        validateNameNotBlank(value);
    }

    private void validateNameLength(String value) {
        if (value.length() > MAX_LENGTH) {
            throw new InvalidNameLengthException();
        }
    }

    private void validateNameNotBlank(String value) {
        if (value.isBlank()) {
            throw new InvalidNameLengthException();
        }
    }

    public String getValue() {
        return value;
    }
}
