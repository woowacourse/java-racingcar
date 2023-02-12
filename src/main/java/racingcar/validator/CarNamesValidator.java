package racingcar.validator;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Range;

public class CarNamesValidator {
    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;
    private static final String BLANK = " ";
    private final Range carNameRange = new Range(NAME_MIN_LENGTH, NAME_MAX_LENGTH);

    public void validateNames(List<String> names) {
        List<String> validNames = new ArrayList<>();
        for (String name : names) {
            validateLength(name);
            validateBlank(name);
            validateDuplicate(name, validNames);
            validNames.add(name);
        }
    }

    private void validateLength(String name) {
        if (carNameRange.isInRange(name.length())) {
            return;
        }
        throw new IllegalArgumentException("자동차 이름은 5자이하만 가능합니다.");
    }

    private void validateBlank(String name) {
        if (!name.contains(BLANK)) {
            return;
        }
        throw new IllegalArgumentException("공백이 포함된 문자는 입력할 수 없습니다.");
    }

    private void validateDuplicate(String name, List<String> validNames) {
        if (!validNames.contains(name)) {
            return;
        }
        throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
    }
}
