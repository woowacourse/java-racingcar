package racingcar.utils.validator;

public class TryCountValidator {

    private static final String DIGIT_ERROR_MESSAGE = "[ERROR] 숫자를 입력해 주세요.";
    private static final String POSITIVE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양수만 가능합니다.";
    private static final int ZERO = 0;

    private TryCountValidator() {
    }

    public static int validateTryCount(final String inputValue) {
        try {
            validatePositive(Integer.parseInt(inputValue));
        } catch (NumberFormatException e) {
            throw new NumberFormatException(DIGIT_ERROR_MESSAGE);
        }
        return Integer.parseInt(inputValue);
    }

    private static void validatePositive(final int inputValue) {
        if (inputValue <= ZERO) {
            throw new IllegalArgumentException(POSITIVE_ERROR_MESSAGE);
        }
    }
}
