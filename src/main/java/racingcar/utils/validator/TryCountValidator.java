package racingcar.utils.validator;

public class TryCountValidator {

    private static final int ZERO = 0;
    private static final String TRY_COUNT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양수만 가능합니다.";

    private TryCountValidator() {
    }

    public static void validateTryCount(final String inputValue) {
        validateNullAndBlank(inputValue);
        validateNotNumber(inputValue);
        validateZeroAndNegative(inputValue);
    }

    private static void validateNullAndBlank(final String inputValue) {
        if ((inputValue == null) || (inputValue.isBlank())) {
            throw new IllegalArgumentException(TRY_COUNT_ERROR_MESSAGE);
        }
    }

    private static void validateNotNumber(final String inputValue) {
        for (int i = 0; i < inputValue.length(); i++) {
            isNumber(inputValue.charAt(i));
        }
    }

    private static void isNumber(char target) {
        if (!Character.isDigit(target)) {
            throw new IllegalArgumentException(TRY_COUNT_ERROR_MESSAGE);
        }
    }

    private static void validateZeroAndNegative(final String inputValue) {
        if (Integer.parseInt(inputValue) <= ZERO) {
            throw new IllegalArgumentException(TRY_COUNT_ERROR_MESSAGE);
        }
    }
}
