package racingcar.domain.car.validator;

import java.util.List;

import racingcar.domain.car.condition.NameDuplication;
import racingcar.exception.car.CarNameExceptionStatus;
import racingcar.exception.car.WrongCarNameException;

public class CarsValidator {

    private static final CarsValidator CAR_GROUP_VALIDATOR = new CarsValidator();

    private CarsValidator() {
    }

    public static void validateNames(final List<String> names) {
        CAR_GROUP_VALIDATOR.validateNameIsDuplicated(names);
    }

    private void validateNameIsDuplicated(final List<String> names) {
        if (checkNameIsDuplicated(names)) {
            throw new WrongCarNameException(CarNameExceptionStatus.NAME_IS_DUPLICATED);
        }
    }

    private boolean checkNameIsDuplicated(final List<String> names) {
        return names.stream()
                .anyMatch(name -> NameDuplication.isExcessiveDuplicated(names, name));
    }

}
