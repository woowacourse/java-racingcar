package validation;

import java.util.stream.Collectors;

public class CountValidator {

    private static final int MIN_COUNT = 0;
    private static final int MAX_COUNT = 1000000000;

    public static ValidateResult validate(final String input) {
        final String EMPTY = "";
        if (input == null || input.equals(EMPTY) || !isNum(input)) {
            return ValidateResult.FAIL_NOT_A_NUMBER;
        }
        if (!isValidCount(input)) {
            return ValidateResult.FAIL_INVALID_COUNT;
        }
        return ValidateResult.SUCCESS;
    }

    private static boolean isValidCount(final String input) {
        int count = Integer.parseInt(input);
        return MIN_COUNT < count && count < MAX_COUNT;
    }

    private static boolean isNum(final String input) {
        if (input == null || input.equals("")) {
            return false;
        }
        return input.chars().mapToObj(c -> (char) c).collect(Collectors.toList()).stream().allMatch(Character::isDigit);
    }
}
