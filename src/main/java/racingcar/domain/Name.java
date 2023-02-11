package racingcar.domain;

import static racingcar.exception.ExceptionMessage.BLANK_CAR_NAME;
import static racingcar.exception.ExceptionMessage.OUT_OF_CAR_NAME_LENGTH;

public class Name {
    private static final int MAX_NAME_LENGTH = 6;

    private final String name;

    public Name(String name) {
        validate();
        this.name = name;
    }

    private void validate() {
        validateCarNameLength();
        validateBlankCarName();
    }

    private void validateBlankCarName() {
        if(name.isBlank()) {
            throw new IllegalArgumentException(BLANK_CAR_NAME.getMessage());
        }
    }

    private void validateCarNameLength() {
        if(name.length() >= MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(OUT_OF_CAR_NAME_LENGTH.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
