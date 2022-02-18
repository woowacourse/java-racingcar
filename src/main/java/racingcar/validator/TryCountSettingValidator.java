package racingcar.validator;

import racingcar.exception.TryCountException;

public class TryCountSettingValidator {

    public static final String NULL_TRY_COUNT_ERROR_MESSAGE = "시도 횟수는 NULL값일 수 없습니다.";
    public static final String BLANK_TRY_COUNT_ERROR_MESSAGE = "시도 횟수는 공백일 수 없습니다.";
    public static final String FLOAT_TRY_COUNT_ERROR_MESSAGE = "시도 횟수는 실수가 될 수 없습니다.";
    public static final String NEGATIVE_TRY_COUNT_ERROR_MESSAGE = "시도 횟수는 음수가 될 수 없습니다.";
    public static final String ZERO_TRY_COUNT_ERROR_MESSAGE = "시도 횟수는 0이 될 수 없습니다.";
    public static final String CHARACTER_TRY_COUNT_ERROR_MESSAGE = "시도 횟수는 문자가 될 수 없습니다.";
    private static final String FLOAT_REG_EXP = "(-|\\+)?[0-9]+\\.[0-9]+";
    private static final String DIGIT_REG_EXP = "(-|\\+)?[0-9]+";

    public String validate(String tryCount) {
        checkNullTryCount(tryCount);
        checkBlankTryCount(tryCount);
        checkFloatTryCount(tryCount);
        checkCharacterTryCount(tryCount);
        checkNegativeTryCount(tryCount);
        checkZeroTryCount(tryCount);
        return tryCount;
    }

    private void checkNullTryCount(String input) {
        if (input == null) {
            throw new TryCountException(NULL_TRY_COUNT_ERROR_MESSAGE);
        }
    }

    private void checkBlankTryCount(String input) {
        if (isBlankTryCount(input)) {
            throw new TryCountException(BLANK_TRY_COUNT_ERROR_MESSAGE);
        }
    }

    private void checkFloatTryCount(String input) {
        if (isFloatTryCount(input)) {
            throw new TryCountException(FLOAT_TRY_COUNT_ERROR_MESSAGE);
        }
    }

    private void checkCharacterTryCount(String input) {
        if (isCharacterTryCount(input)) {
            throw new TryCountException(CHARACTER_TRY_COUNT_ERROR_MESSAGE);
        }
    }

    private void checkNegativeTryCount(String input) {
        if (isNegativeTryCount(input)) {
            throw new TryCountException(NEGATIVE_TRY_COUNT_ERROR_MESSAGE);
        }
    }

    private void checkZeroTryCount(String input) {
        if (isZeroTryCount(input)) {
            throw new TryCountException(ZERO_TRY_COUNT_ERROR_MESSAGE);
        }
    }

    private boolean isBlankTryCount(String input) {
        return input.isBlank();
    }

    private boolean isFloatTryCount(String input) {
        return input.matches(FLOAT_REG_EXP);
    }

    private boolean isCharacterTryCount(String input) {
        return !input.matches(DIGIT_REG_EXP);
    }

    private boolean isNegativeTryCount(String input) {
        return Integer.parseInt(input) < 0;
    }

    private boolean isZeroTryCount(String input) {
        return Integer.parseInt(input) == 0;
    }
}
