package racingcar.domain.validator;

import java.util.Arrays;
import racingcar.exception.CarNameException;
import racingcar.view.NamesInput;

public class NamesInputValidator {

    public static final String NULL_INPUT_ERROR_MESSAGE = "null 값이 입력 될 수 없습니다.";
    public static final String INVALID_LENGTH_ERROR_MESSAGE = "자동차 이름은 5글자 이하여야 합니다.";
    public static final String EMPTY_NAME_ERROR_MESSAGE = "자동차 이름은 공백일 수 없습니다.";
    public static final String DUPLICATE_NAME_ERROR_MESSAGE = "자동차 이름은 중복일 수 없습니다.";
    private static final int NAME_UPPER_LENGTH = 5;

    public String validate(String names) {
        checkNullInput(names);
        checkNameLength(names);
        checkEmptyName(names);
        checkDuplicateName(names);
        return names;
    }

    private void checkNullInput(String names) {
        if (isNullInput(names)) {
            throw new CarNameException(NULL_INPUT_ERROR_MESSAGE);
        }
    }

    private void checkNameLength(String names) {
        if (isInvalidLength(names)) {
            throw new CarNameException(INVALID_LENGTH_ERROR_MESSAGE);
        }
    }

    private void checkEmptyName(String names) {
        if (isEmptyName(names)) {
            throw new CarNameException(EMPTY_NAME_ERROR_MESSAGE);
        }
    }

    private void checkDuplicateName(String names) {
        if (isDuplicateName(names)) {
            throw new CarNameException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }

    private boolean isNullInput(String names) {
        if (names == null) {
            return true;
        }
        return false;
    }

    private boolean isInvalidLength(String names) {
        return Arrays.stream(names.split(NamesInput.NAME_DELIMITER))
                .anyMatch(n -> n.length() > NAME_UPPER_LENGTH);
    }

    private boolean isEmptyName(String names) {
        return Arrays.stream(names.split(NamesInput.NAME_DELIMITER))
                .anyMatch(String::isEmpty);
    }

    private boolean isDuplicateName(String names) {
        return Arrays.stream(names.split(NamesInput.NAME_DELIMITER))
                .distinct()
                .count() != names.split(NamesInput.NAME_DELIMITER).length;
    }
}
