package calculator.utils.validator;

public class UserInputValidator {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";

    public static boolean isCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    public static boolean isNullOrWhiteSpace(String str) {
        return str == null || str.isBlank();
    }
}
