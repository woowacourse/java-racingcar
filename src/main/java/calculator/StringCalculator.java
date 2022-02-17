package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String NUMBER_FORMAT_EXCEPTION = "숫자가 아닌 문자는 허용되지 않습니다.";
    private static final String NEGATIVE_NUMBER_EXCEPTION = "숫자가 아닌 문자는 허용되지 않습니다.";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int INPUT_STRING_GROUP = 2;
    private static final StringBuilder delimiters = new StringBuilder(",|:");

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        List<String> numbers = split(input);
        int sum = addAllNumber(numbers);
        return sum;
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static List<String> split(String input) {
        input = checkCustomDelimiter(input);
        return Arrays.asList(input.split(delimiters.toString()));
    }

    private static int addAllNumber(List<String> numbers) {
        return numbers.stream().mapToInt(StringCalculator::toInts).sum();
    }

    private static String checkCustomDelimiter(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (m.find()) {
            return findCustomDelimiter(m);
        }
        return input;
    }

    private static String findCustomDelimiter(Matcher m) {
        String customDelimiter = m.group(CUSTOM_DELIMITER_GROUP);
        delimiters.append("|").append(customDelimiter);
        return m.group(INPUT_STRING_GROUP);
    }

    private static int toInts(String number) {
        validateNumber(number);
        return Integer.parseInt(number);
    }

    private static void validateNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
        if (Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION);
        }
    }
}
