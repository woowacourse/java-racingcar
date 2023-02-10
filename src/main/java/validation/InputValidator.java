package validation;

public class InputValidator {

    private static String EMPTY = "";

    public static ValidateResult validate(final String input) {
        if (!isNotEmpty(input)) {
            return ValidateResult.FAIL_EMPTY;
        }
        return ValidateResult.SUCCESS;
    }

    public static boolean isNotEmpty(final String input) {
        return input != null && !input.equals(EMPTY);
    }
}
