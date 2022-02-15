package racingcar.domain.car.validator;

import racingcar.domain.car.condition.NameLength;
import racingcar.exception.car.CarNameEmptyException;
import racingcar.exception.car.CarNameNullException;
import racingcar.exception.car.CarNameTooLongException;

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
            throw new CarNameNullException();
        }
    }

    private void validateNameIsEmpty(String name) {
        if (name.isEmpty()) {
            throw new CarNameEmptyException();
        }
    }

    private void validateNameIsTooLong(String name) {
        if (NameLength.isTooLong(name)) {
            throw new CarNameTooLongException();
        }
    }

}
