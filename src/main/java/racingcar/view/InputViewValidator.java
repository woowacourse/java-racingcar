package racingcar.view;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class InputViewValidator {

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String CAR_NAMES_BLANK_ERROR = ERROR_PREFIX + "경주할 자동차 이름이 입력되지 않았습니다.";
    private static final String CAR_NAMES_DUPLICATE_ERROR = ERROR_PREFIX + "경주할 자동차 이름이 중복되었습니다.";
    private static final String TRY_NUM_BLANK_ERROR = ERROR_PREFIX + "시도할 횟수가 입력되지 않았습니다.";
    private static final String TRY_NUM_NOT_INTEGER_ERROR = ERROR_PREFIX + "시도할 횟수가 정수가 아닙니다.";
    private static final String TRY_NUM_NOT_POSITIVE_ERROR = ERROR_PREFIX + "시도할 횟수는 1 이상이어야 합니다.";

    public void validateCarNames(String carNames) {
        if (isBlank(carNames)) {
            throw new IllegalArgumentException(CAR_NAMES_BLANK_ERROR);
        }
    }

    private boolean isBlank(String inputValue) {
        return inputValue.length() < 1;
    }

    public void validateSplitCarNames(String[] splitCarNames) {
        if (isDuplicated(splitCarNames)) {
            throw new IllegalArgumentException(CAR_NAMES_DUPLICATE_ERROR);
        }
    }

    private boolean isDuplicated(String[] splitCarNames) {
        Set<String> removedDuplicatedSplitCarNames = Arrays.stream(splitCarNames)
                .collect(Collectors.toSet());
        return splitCarNames.length != removedDuplicatedSplitCarNames.size();
    }

    public void validateTryNum(String tryNum) {
        if (isBlank(tryNum)) {
            throw new IllegalArgumentException(TRY_NUM_BLANK_ERROR);
        }
        if (isNotInteger(tryNum)) {
            throw new IllegalArgumentException(TRY_NUM_NOT_INTEGER_ERROR);
        }
        if (isNotPositive(tryNum)) {
            throw new IllegalArgumentException(TRY_NUM_NOT_POSITIVE_ERROR);
        }
    }

    private boolean isNotInteger(String tryNum) {
        try {
            Integer.parseInt(tryNum);
        } catch (NumberFormatException error) {
            return true;
        }
        return false;
    }

    private boolean isNotPositive(String tryNum) {
        return Integer.parseInt(tryNum) < 1;
    }
}

