package model;

import java.util.regex.Pattern;

public class Round {

    private static final String NATURAL_FORMAT_REGEX = "^[\\d]*$";
    private static final String ZERO = "0";
    private static final String PREFIX_ERROR = "[ERROR] ";
    private static final String ERROR_ROUND_IS_NULL = "시도 횟수를 입력해 주십시오.";
    private static final String ERROR_ROUND_IS_NATURAL_NUMBER = "시도 횟수는 자연수여야 합니다.";

    private int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round from(String round) {
        validate(round);
        return new Round(Integer.parseInt(round));
    }

    private static void validate(String input) {
        checkIsNull(input);
        checkIsNumber(input);
        checkIsZero(input);
    }

    private static void checkIsNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(PREFIX_ERROR + ERROR_ROUND_IS_NULL);
        }
    }

    private static void checkIsNumber(String input) {
        if (!Pattern.matches(NATURAL_FORMAT_REGEX, input)) {
            throw new IllegalArgumentException(PREFIX_ERROR + ERROR_ROUND_IS_NATURAL_NUMBER);
        }
    }

    private static void checkIsZero(String input) {
        if (input.equals(ZERO)) {
            throw new IllegalArgumentException(PREFIX_ERROR + ERROR_ROUND_IS_NATURAL_NUMBER);
        }
    }

    public int getRound() {
        return round;
    }
}
