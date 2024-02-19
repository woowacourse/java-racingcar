package racingcar.util;

import java.util.List;
import java.util.Set;

public class Validator {
    private static final int MIN_TRY_COUNT = 1;
    private static final int MAX_TRY_COUNT = 50;
    private static final String EMPTY_CAR_NAMES_ERROR_MSG = "자동차 이름 목록을 입력해주세요.";
    private static final String CAR_NAME_LENGTH_ERROR_MSG = "자동차 이름은 1자 이상 5자 이하여야 합니다.";
    private static final String NAME_DUPLICATED_ERROR_MSG = "자동차 이름은 중복될 수 없습니다.";
    private static final String TRY_COUNT_INTEGER_FORMAT_ERROR_MSG = "시도 회수는 정수여야 합니다.";
    private static final String TRY_COUNT_NEGATIVE_INTEGER_ERROR_MSG = "시도할 회수는 양의 정수여야 합니다.";
    private static final String TRY_COUNT_OVER_MAX_ERROR_MSG = "시도할 회수가 너무 많습니다. 다시 입력해주세요.";

    public static void validateEmptyCarNames(final String carNames) {
        if(carNames.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAMES_ERROR_MSG);
        }
    }

    public static void validateCarNames(final List<String> carNames) {
        for(String carName: carNames) {
            validateCarNamesFormat(carName);
        }
        validateDuplicatedNames(carNames);
    }

    private static void validateCarNamesFormat(final String carName) {
        if (carName.isBlank() || carName.isEmpty() || carName.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MSG);
        }
    }

    private static void validateDuplicatedNames(final List<String> carNames) {
        final Set<String> uniqueNames = Set.copyOf(carNames);
        if(uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException(NAME_DUPLICATED_ERROR_MSG);
        }
    }

    public static int validateTryCount(final String tryCount) {
        int validTryCount;
        try {
            validTryCount = Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_INTEGER_FORMAT_ERROR_MSG);
        }
        if (validTryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException(TRY_COUNT_NEGATIVE_INTEGER_ERROR_MSG);
        }
        if (validTryCount > MAX_TRY_COUNT) {
            throw new IllegalArgumentException(TRY_COUNT_OVER_MAX_ERROR_MSG);
        }
        return validTryCount;
    }
}
