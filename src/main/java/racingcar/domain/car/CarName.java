package racingcar.domain.car;

import racingcar.exception.ErrorMessage;
import racingcar.exception.ErrorMessageDetail;
import racingcar.exception.InvalidInputException;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    private final String name;

    public CarName(final String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(final String name) {
        if (name.isBlank() || MIN_NAME_LENGTH > name.length() || name.length() > MAX_NAME_LENGTH) {
            String errorDetail = String.format(ErrorMessageDetail.CAR_NAME_RAGE, MIN_NAME_LENGTH, MAX_NAME_LENGTH);
            throw new InvalidInputException(ErrorMessage.INVALID_CAR_NAME_LENGTH, errorDetail);
        }
    }

    public String getName() {
        return name;
    }
}
