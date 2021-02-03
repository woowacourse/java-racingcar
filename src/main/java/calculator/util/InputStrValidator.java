package calculator.util;

public class InputStrValidator {
    public static boolean isEmptyOrNull(String inputStr) {
        return ("".equals(inputStr) || inputStr == null);
    }
}
