package racingcar.domain.car.validator;

import racingcar.domain.car.condition.NameLength;
import racingcar.exception.car.CarNameEmptyException;
import racingcar.exception.car.CarNameNullException;
import racingcar.exception.car.CarNameTooLongException;

public class CarValidator {

    private static final CarValidator carValidator = new CarValidator();

    public static void validateName(String name) {
        carValidator.validateNameIsNull(name);
        carValidator.validateNameIsEmpty(name);
        carValidator.validateNameIsTooLong(name);
    }

    void validateNameIsNull(String name) {
        if (name == null) {
            throw new CarNameNullException();
        }
    }

    void validateNameIsEmpty(String name) {
        if (name.isEmpty()) {
            throw new CarNameEmptyException();
        }
    }

    void validateNameIsTooLong(String name) {
        if (NameLength.isTooLong(name)) {
            throw new CarNameTooLongException();
        }
    }

}
