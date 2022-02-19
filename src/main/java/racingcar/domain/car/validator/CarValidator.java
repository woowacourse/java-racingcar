package racingcar.domain.car.validator;

import racingcar.domain.car.condition.NameLength;
import racingcar.exception.WrongArgumentException;
import racingcar.exception.status.car.CarNameExceptionStatus;

public class CarValidator {

    private static final CarValidator CAR_VALIDATOR = new CarValidator();

    private CarValidator() {
    }

    public static void validateName(final String name) {
        CAR_VALIDATOR.validateNameIsNull(name);
        CAR_VALIDATOR.validateNameIsEmpty(name);
        CAR_VALIDATOR.validateNameIsTooLong(name);
    }

    private void validateNameIsNull(final String name) {
        if (name == null) {
            throw new WrongArgumentException(CarNameExceptionStatus.NAME_IS_NULL);
        }
    }

    private void validateNameIsEmpty(final String name) {
        if (name.isEmpty()) {
            throw new WrongArgumentException(CarNameExceptionStatus.NAME_IS_EMPTY);
        }
    }

    private void validateNameIsTooLong(final String name) {
        if (NameLength.isTooLong(name)) {
            throw new WrongArgumentException(CarNameExceptionStatus.NAME_IS_TOO_LONG);
        }
    }

}
