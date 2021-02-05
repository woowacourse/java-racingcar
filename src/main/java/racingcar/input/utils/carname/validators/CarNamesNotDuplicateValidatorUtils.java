package racingcar.input.utils.carname.validators;

import java.util.List;
import racingcar.input.utils.carname.exception.DuplicateCarNamesException;

public class CarNamesNotDuplicateValidatorUtils {

    private CarNamesNotDuplicateValidatorUtils() {
    }

    public static void validateAllCarNamesNotDuplicate(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new DuplicateCarNamesException("자동차 이름은 중복되지 않아야 합니다.");
        }
    }
}
