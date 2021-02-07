package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import racingcar.input.utils.carname.validators.exceptions.DuplicateCarNamesException;

public class CarNamesValidator {
    public void validateNotDuplicate(List<String> carNames) {
        if (new HashSet<>(carNames).size() != carNames.size()) {
            throw new DuplicateCarNamesException("자동차 이름은 중복되지 않아야 합니다.");
        }
    }
}
