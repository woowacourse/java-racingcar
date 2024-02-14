package racingcar.domain.car;

import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public class CarName {
    private final static int MAX_NAME_LENGTH = 5;
    private final String name;

    public CarName(final String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new InvalidInputException(ErrorMessage.INVALID_CAR_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
