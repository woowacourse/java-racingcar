package racingcar.validator;

public class RoundNumberValidator {
    public static final String POSITIVE_INTEGER_REGEX = "^([1-9][0-9]*)$";
    private static final String INVALID_ROUND_ERROR_MESSAGE = "자연수로 입력해 주세요.";

    public static void validate(final String round) {
        if (!isPositiveNumber(round)) {
            throw new IllegalArgumentException(INVALID_ROUND_ERROR_MESSAGE);
        }
    }

    private static boolean isPositiveNumber(final String round) {
        return round.matches(POSITIVE_INTEGER_REGEX);
    }
}
