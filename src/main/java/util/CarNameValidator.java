package util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator implements Validator {

    private static final int LENGTH_LOWER_BOUND = 1;
    private static final int LENGTH_UPPER_BOUND = 5;

    private static final String EXCEEDED_CAR_NAME_LENGTH_ERROR = "자동차명은 1 ~ 5 글자로 입력해야합니다.";
    private static final String EXISTS_DUPLICATE_CAR_NAME_ERROR = "자동차명은 중복되어선 안됩니다.";

    @Override
    public void validate(Object target) {
        validateCarNamesIsEmpty((List<String>) target);
        validateDuplicateCarName((List<String>) target);
        validateCarNameLength((List<String>) target);
    }

    private boolean isCorrectLength(List<String> carNames) {
        return carNames.stream()
                .allMatch(carName -> LENGTH_LOWER_BOUND <= carName.length() && carName.length() <= LENGTH_UPPER_BOUND);
    }


    private void validateCarNamesIsEmpty(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(EXCEEDED_CAR_NAME_LENGTH_ERROR);
        }
    }

    private void validateCarNameLength(List<String> carNames) {
        if (!isCorrectLength(carNames)) {
            throw new IllegalArgumentException(EXCEEDED_CAR_NAME_LENGTH_ERROR);
        }
    }

    private void validateDuplicateCarName(List<String> carName) {
        Set<String> duplicateChecker = new HashSet<>(carName);

        if (duplicateChecker.size() != carName.size()) {
            throw new IllegalArgumentException(EXISTS_DUPLICATE_CAR_NAME_ERROR);
        }
    }
}
