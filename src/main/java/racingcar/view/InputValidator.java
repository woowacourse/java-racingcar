package racingcar.view;

import static java.text.MessageFormat.format;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private static final String INVALID_NAME_MESSAGE = "차의 이름은 {0}자 이상, {1}자 이하여야 합니다.";
    private static final int NAME_LENGTH_LOWER_BOUND = 1;
    private static final int NAME_LENGTH_UPPER_BOUND = 5;
    private static final String DUPLICATED_NAMES_MESSAGE = "중복된 차 이름이 없어야 합니다.";
    private static final String INVALID_COUNT_MESSAGE = "시도할 횟수는 {0}이상, {1}이하의 정수여야 합니다.";
    private static final int COUNT_LOWER_BOUND = 1;
    private static final int COUNT_UPPER_BOUND = 100;

    public void validateNames(final List<String> names) {
        names.forEach(this::validateNameLength);
        validateDuplicateNames(names);
    }

    private void validateNameLength(final String name) {
        if (isInvalidNameLength(name)) {
            throw new IllegalArgumentException(
                    format(INVALID_NAME_MESSAGE, NAME_LENGTH_LOWER_BOUND, NAME_LENGTH_UPPER_BOUND)
            );
        }
    }

    private boolean isInvalidNameLength(final String name) {
        return name.length() < NAME_LENGTH_LOWER_BOUND || NAME_LENGTH_UPPER_BOUND < name.length();
    }

    private void validateDuplicateNames(final List<String> names) {
        Set<String> nonDuplicatedNames = new HashSet<>(names);
        if (names.size() != nonDuplicatedNames.size()) {
            throw new IllegalArgumentException(DUPLICATED_NAMES_MESSAGE);
        }
    }

    public void validateCount(final int count) {
        if (isInvalidCount(count)) {
            throw new IllegalArgumentException(
                    format(INVALID_COUNT_MESSAGE, COUNT_LOWER_BOUND, COUNT_UPPER_BOUND)
            );
        }
    }

    private boolean isInvalidCount(final int count) {
        return count < COUNT_LOWER_BOUND || COUNT_UPPER_BOUND < count;
    }
}
