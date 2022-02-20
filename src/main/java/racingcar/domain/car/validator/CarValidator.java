package racingcar.domain.car.validator;

import racingcar.domain.car.condition.NameLength;
import racingcar.exception.car.CarNameExceptionStatus;
import racingcar.exception.car.WrongCarNameException;

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
            throw new WrongCarNameException(CarNameExceptionStatus.NAME_IS_NULL);
        }
    }

    private void validateNameIsEmpty(final String name) {
        if (name.isEmpty()) {
            throw new WrongCarNameException(CarNameExceptionStatus.NAME_IS_EMPTY);
        }
    }

    private void validateNameIsTooLong(final String name) {
        if (NameLength.isTooLong(name)) {
            throw new WrongCarNameException(CarNameExceptionStatus.NAME_IS_TOO_LONG);
        }
    }

}
