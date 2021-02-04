package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputStrValidator {
    public static boolean isEmptyOrNull(String inputStr) {
        return ("".equals(inputStr) || inputStr == null);
    }

    public static boolean isOnlyOneNumber(String inputStr) {
        String pattern = "^[0-9]*$";
        return Pattern.matches(pattern, inputStr);
    }
}
