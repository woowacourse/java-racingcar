package calculator.util;

import java.util.List;
import java.util.regex.Pattern;

public class InputStrValidator {
    private InputStrValidator() {
    }

    public static boolean isEmptyOrNull(final String inputStr) {
        return ("".equals(inputStr) || inputStr == null);
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

    private static boolean isNumber(final String inputStr) {
        String pattern = "^[0-9]*$";
        return Pattern.matches(pattern, inputStr);
    }
}