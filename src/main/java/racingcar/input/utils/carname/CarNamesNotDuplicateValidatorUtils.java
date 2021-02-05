package racingcar.input.utils.carname;

import java.util.List;
import racingcar.input.utils.carname.exception.InvalidDuplicateCarNamesException;

public class CarNamesNotDuplicateValidatorUtils {
    public static void isAllCarNamesNotDuplicate(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new InvalidDuplicateCarNamesException("자동차 이름은 중복되지 않아야 합니다.");
        }
    }
}
