package racingcar.domain.car.validator;

import racingcar.domain.car.condition.NameLength;
import racingcar.exception.WrongArgumentException;
import racingcar.exception.status.car.CarNameExceptionStatus;

public class CarValidator {

    private static final CarValidator CAR_VALIDATOR = new CarValidator();

    private CarValidator() { }

    public static void validateName(String name) {
        CAR_VALIDATOR.validateNameIsNull(name);
        CAR_VALIDATOR.validateNameIsEmpty(name);
        CAR_VALIDATOR.validateNameIsTooLong(name);
    }

    private void validateNameIsNull(String name) {
        if (name == null) {
            throw new WrongArgumentException(CarNameExceptionStatus.NAME_IS_NULL_EXCEPTION_STATUS);
        }
    }

    private void validateNameIsEmpty(String name) {
        if (name.isEmpty()) {
            throw new WrongArgumentException(CarNameExceptionStatus.NAME_IS_EMPTY_EXCEPTION_STATUS);
        }
    }

    private void validateNameIsTooLong(String name) {
        if (NameLength.isTooLong(name)) {
            throw new WrongArgumentException(CarNameExceptionStatus.NAME_IS_TOO_LONG_EXCEPTION_STATUS);
        }
    }

}
