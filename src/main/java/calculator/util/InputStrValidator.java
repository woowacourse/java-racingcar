package calculator.util;

import java.util.List;
import java.util.regex.Pattern;

public class InputStrValidator {
    private static final Pattern PATTERN = Pattern.compile("^[0-9]*$");

    private InputStrValidator() {
    }

    public static boolean isEmptyOrNull(final String inputString) {
        return ("".equals(inputString) || inputString == null);
    }

    public static boolean isHasOnlyOneNumber(final String inputStr) {
        return InputStrValidator.isNumber(inputStr);
    }

    public static void checkValidNumbers(final List<String> splitStrings) {
        boolean result = splitStrings.stream()
                .allMatch(InputStrValidator::isNumber);
        if (!result) {
            throw new RuntimeException();
        }
    }

    private static boolean isNumber(final String inputString) {
        return PATTERN.matcher(inputString).matches();
    }
}