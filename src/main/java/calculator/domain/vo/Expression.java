package calculator.domain.vo;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.StringUtil;

public class Expression {

    private static final String NONE_INTEGER_ERROR_MESSAGE = "숫자가 아닌 입력입니다. 구분자를 이용해서 숫자를 입력해주세요.";
    private static final String NEGATIVE_VALUE_ERROR_MESSAGE = "음수 값을 입력했습니다. 양수를 입력해주세요.";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String BASIC_DELIMITER_COMMA = ",";
    private static final String BASIC_DELIMITER_COLON = ":";
    private static final String INIT_DELIMITER =
            "[" + BASIC_DELIMITER_COMMA + BASIC_DELIMITER_COLON + "]";
    private static final String DELIMITER_FORMAT =
            "[" + BASIC_DELIMITER_COMMA + BASIC_DELIMITER_COLON + "%s]";

    private static final int FIRST_PATTERN = 1;
    private static final int SECOND_PATTERN = 2;

    private String expression;
    private String delimiter;

    public Expression(String input) {
        String delimiter = INIT_DELIMITER;
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(FIRST_PATTERN);
            delimiter = String.format(DELIMITER_FORMAT, customDelimiter);
            input = matcher.group(SECOND_PATTERN);
        }
        this.expression = input;
        this.delimiter = delimiter;
    }

    public int sum() {
        return addAll(toIntegers(StringUtil.split(expression, delimiter)));
    }

    private static int[] toIntegers(String[] array) {
        int[] numbers = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int result = toInteger(array[i]);
            validateNegative(result);
            numbers[i] = result;
        }
        return numbers;
    }

    private static int toInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException(NONE_INTEGER_ERROR_MESSAGE);
        }
    }

    private static void validateNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(NEGATIVE_VALUE_ERROR_MESSAGE);
        }
    }

    private static int addAll(int[] numbers) {
        return Arrays.stream(numbers)
                .sum();
    }
}
