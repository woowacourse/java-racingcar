package calculator.view;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class InputValidator {
    public static final String ERROR_NUMBER_RIGHT_FORMAT = "[error] 숫자를 입력해주세요.";
    private static final String COMMA_DELIMITER = ",";
    private static final String COLON_DELIMITER = ":";
    private static final int NUMBER = 0;

    private InputValidator() {
    }

    public static boolean isInputNullOrBlankOrEmpty(String input) {
        return isBlankInput(input);
    }

    private static boolean isBlankInput(String input) {
        return StringUtils.isBlank(input);
    }

    public static void checkValidateNumbers(List<String> numbers) {
        numbers.forEach(InputValidator::checkValidateNumber);
    }

    private static void checkValidateNumber(String number) {
        if (isRightNumber(number)) {
            return;
        }
        throw new IllegalArgumentException(ERROR_NUMBER_RIGHT_FORMAT);
    }

    private static boolean isRightNumber(String number) {
        if (number.equals(COMMA_DELIMITER) || number.equals(COLON_DELIMITER)) {
            return true;
        }
        return Character.isDigit((number.charAt(NUMBER)));
    }
}
