package stringadder;

import java.util.regex.Pattern;

public class ValidateNumber {
    public static final String ERROR_MESSAGE_NEGATIVE_NUMBER = "0 이상의 수를 입력하세요";
    public static final String ERROR_MESSAGE_NOT_INTEGER = "숫자만 입력하세요.";
    public static final String MINUS_SIGN = "-";

    public static void validate(String[] splittedInput) {
        for (String str : splittedInput) {
            isNegativeNumber(str);
            isNotInteger(str);
        }
    }

    private static void isNegativeNumber(String str) {
        if (str.contains(MINUS_SIGN)) {
            throw new RuntimeException(ERROR_MESSAGE_NEGATIVE_NUMBER);
        }
    }

    private static void isNotInteger(String inputString) {
        Pattern pattern = Pattern.compile("\\D");
        if (pattern.matcher(inputString).find()) {
            throw new RuntimeException(ERROR_MESSAGE_NOT_INTEGER);
        }
    }
}
