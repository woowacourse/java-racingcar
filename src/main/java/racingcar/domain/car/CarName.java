package racingcar.domain.car;

import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public CarName(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        validateNameLength(name);
        validateNameFormat(name);
    }

    private void validateNameLength(final String name) {
        if (name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new InvalidInputException(ErrorMessage.INVALID_CAR_NAME_LENGTH);
        }
    }

    private void validateNameFormat(final String name) {
        if (!name.matches("[a-zA-Z0-9ㄱ-ㅎㅏ-ㅣ가-힣]*")) {
            throw new InvalidInputException(ErrorMessage.INVALID_CAR_NAME_FORMAT);
        }
    }

    public String getName() {
        return name;
    }
}
