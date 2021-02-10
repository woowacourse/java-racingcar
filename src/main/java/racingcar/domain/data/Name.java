package racingcar.domain.data;

import racingcar.utils.exception.InvalidNameLengthException;

public class Name {
    private static int NAME_MAX_LENGTH = 5;
    private final String value;

    public Name(String value) {
        if (value.length() <= 0 || value.length() > NAME_MAX_LENGTH) {
            throw new InvalidNameLengthException(NAME_MAX_LENGTH);
        }
        this.value = value;
    }

    public String value() {
        return value;
    }
}
