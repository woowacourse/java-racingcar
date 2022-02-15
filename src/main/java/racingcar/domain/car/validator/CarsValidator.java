package racingcar.domain.car.validator;

import java.util.List;

import racingcar.domain.car.condition.NameDuplication;
import racingcar.exception.car.CarNameDuplicatedException;

public class CarsValidator {

    private static final CarsValidator CAR_GROUP_VALIDATOR = new CarsValidator();

    private CarsValidator() { }

    public static void validateNames(List<String> names) {
        CAR_GROUP_VALIDATOR.validateNameIsDuplicated(names);
    }

    private void validateNameIsDuplicated(List<String> names) {
        if (checkNameIsDuplicated(names)) {
            throw new CarNameDuplicatedException();
        }
    }

    private boolean checkNameIsDuplicated(List<String> names) {
        return names.stream()
                .anyMatch(name -> NameDuplication.isExcessiveDuplicated(names, name));
    }

}
