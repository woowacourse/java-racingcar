package model;

import java.util.regex.Pattern;

import static view.OutputView.ERROR_PREFIX;

public class Round {

    private static final String NATURAL_FORMAT_REGEX = "^[\\d]*$";

    private final int round;

    private Round(final int round) {
        this.round = round;
    }

    public static Round from(final String round) {
        validate(round);
        return new Round(Integer.parseInt(round));
    }

    private static void validate(String input) {
        checkIsNull(input);
        checkIsNaturalNumber(input);
        checkIsZero(input);
    }

    private static void checkIsNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ERROR_PREFIX + "시도 횟수를 입력해 주십시오.");
        }
    }

    private static void checkIsNaturalNumber(String input) {
        if (!Pattern.matches(NATURAL_FORMAT_REGEX, input)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "시도 횟수는 자연수여야 합니다.");
        }
    }

    private static void checkIsZero(String input) {
        if (input.equals("0")) {
            throw new IllegalArgumentException(ERROR_PREFIX + "시도 횟수를 입력해 주세요.");
        }
    }

    public int getRound() {
        return round;
    }
}
