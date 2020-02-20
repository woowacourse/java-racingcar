package calculator.domain;

public class Calculator {
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final char STARTS_OF_CUSTOM_DELIMITER = '/';
    public static final int DELIMITER_INDEX = 0;
    public static final int EXPRESSION = 5;
    public static final int CUSTOM_DELIMITER_BEGIN_INDEX = 2;
    public static final int CUSTOM_DELIMITER_END_INDEX = 3;

    public static String[] splitString(String input) {
        String delimiter = DEFAULT_DELIMITER;
        if (isCustomDelimiter(input)) {
            delimiter = findCustomDelimiter(input);
            input = input.substring(EXPRESSION);
        }
        return input.split(delimiter);
    }

    private static String findCustomDelimiter(String input) {
        return input.substring(CUSTOM_DELIMITER_BEGIN_INDEX, CUSTOM_DELIMITER_END_INDEX);
    }

    private static boolean isCustomDelimiter(String input) {
        return input.charAt(DELIMITER_INDEX) == STARTS_OF_CUSTOM_DELIMITER;
    }

    public static int calculate(String[] numbers) throws NumberFormatException {
        int result = 0;
        for (String number : numbers) {
            int parsedNumber = Integer.parseInt(number);
            validatePositiveNumber(parsedNumber);
            result += parsedNumber;
        }
        return result;
    }

    private static void validatePositiveNumber(int parsedNumber) {
        if (isNegativeNumber(parsedNumber)) {
            throw new IllegalArgumentException(String.format("음수의 숫자는 입력이 불가능합니다. 입력값 : %d", parsedNumber));
        }
    }

    private static boolean isNegativeNumber(int parsedNumber) {
        return parsedNumber < 0;
    }
}