package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 클래스 이름 : Calculator.java
 *
 * @author 보스독
 * @author 작은곰
 * @author 토니
 * @version 1.0
 * <p>
 * 날짜 : 2020.02.11 화요일
 */

public class Calculator {
    private static final String REGEX = "//(.)\n(.*)";
    private static final int SINGLE_NUMBER = 1;
    private static final int NULL_OR_EMPTY_RETURN_VALUE = 0;
    private static final String NEGATIVE_SYMBOL = "-";
    private static final String OR_SYMBOL = "|";

    public static int splitAndSum(final String input) {
        if (isNullOrEmpty(input)) {
            return NULL_OR_EMPTY_RETURN_VALUE;
        }
        String[] inputs = splitByDelimiter(input);

        if (inputs.length == SINGLE_NUMBER) {
            isContainNegative(inputs[0]);
            checkDelimiter(inputs[0]);
            return Integer.parseInt(inputs[0]);
        }
        return sumNumbers(inputs);
    }

    private static String[] splitByDelimiter(String input) {
        String delimiter = ",|:";
        Matcher m = Pattern.compile(REGEX).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            delimiter += OR_SYMBOL + customDelimiter;
            input = m.group(2);
        }
        return input.split(delimiter);
    }

    private static int sumNumbers(final String[] inputs) {
        int result = 0;
        for (String value : inputs) {
            isContainNegative(value);
            int number = checkDelimiter(value);
            result += number;
        }
        return result;
    }

    private static boolean isNullOrEmpty(final String input) {
        return input == null || input.isEmpty();
    }

    private static void isContainNegative(final String value) {
        if (value.contains(NEGATIVE_SYMBOL)) {
            throw new RuntimeException("음수는 포함할 수 없습니다.");
        }
    }

    private static int checkDelimiter(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자와 구분자만 입력할 수 있습니다.");
        }
    }
}
