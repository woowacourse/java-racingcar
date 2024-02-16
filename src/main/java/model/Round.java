package model;

import java.util.regex.Pattern;

import static util.ErrorMessage.ERROR_ROUND_IS_NATURAL_NUMBER;
import static util.ErrorMessage.ERROR_ROUND_IS_NULL;

public class Round {

    private static final String NATURAL_FORMAT_REGEX = "^[\\d]*$";

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
            throw new IllegalArgumentException(ERROR_ROUND_IS_NULL.getMessage());
        }
    }

    private static void checkIsNumber(String input) {
        if (!Pattern.matches(NATURAL_FORMAT_REGEX, input)) {
            throw new IllegalArgumentException(ERROR_ROUND_IS_NATURAL_NUMBER.getMessage());
        }
    }

    private static void checkIsZero(String input) {
        if (input.equals(0)) {
            throw new IllegalArgumentException(ERROR_ROUND_IS_NATURAL_NUMBER.getMessage());
        }
    }

    public int getRound() {
        return round;
    }
}
