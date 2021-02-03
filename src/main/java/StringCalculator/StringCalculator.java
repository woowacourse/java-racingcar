package StringCalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String BASIC_DELIMITER = ",|:";
    private static final int ZERO = 0;
    private static final int ONLY_ONE_NUMBER = 1;
    private static final int FIRST_INDEX = 0;
    private static final String DELIMITER = "(.)";
    private static final String FILTERED_STRING = "(.*)";
    private static final int DELIMITER_SEQUENCE_NUMBER = 1;
    private static final int FILTERED_STRING_SEQUENCE_NUMBER = 2;
    private static final String PREFIX = "//";
    private static final String SUFFIX = "\n";
    private static final int NEGATIVE_STANDARD_NUMBER = 0;
    private static final String ERROR_STRING_HAS_NOT_NEGATIVE_NUMBER_MESSAGE = "[ERROR] 음수는 존재할 수 없습니다.";
    private static final String ERROR_STRING_IS_NOT_NUMBER_MESSAGE = "[ERROR] 문자열이 숫자가 아닙니다.";

    public static int splitAndSum(String string) {
        if (string == null || string.isEmpty()) {
            return ZERO;
        }

        return sum(string);
    }

    private static int sum(String string) {
        Matcher matcher = Pattern.compile(PREFIX + DELIMITER + SUFFIX + FILTERED_STRING).matcher(string);
        if (matcher.find()) {
            return sumSplitByCustomDelimiter(matcher);
        }

        return sumSplitByDefaultDelimiter(string);
    }

    private static int sumSplitByDefaultDelimiter(String string) {
        String[] numbers = string.split(BASIC_DELIMITER);
        return addAllNumbers(numbers);
    }

    private static int sumSplitByCustomDelimiter(Matcher matcher) {
        String customDelimiter = matcher.group(DELIMITER_SEQUENCE_NUMBER);
        String[] numbers = matcher.group(FILTERED_STRING_SEQUENCE_NUMBER).split(customDelimiter);
        return addAllNumbers(numbers);
    }

    private static int addAllNumbers(String[] numbers) {
        validateNumbers(numbers);
        if (numbers.length == ONLY_ONE_NUMBER) {
            return Integer.parseInt(numbers[FIRST_INDEX]);
        }

        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static void validateNumbers(String[] numbers) {
        for (String number : numbers) {
            validateNumber(number);
        }
    }

    private static void validateNumber(String number) {
        if (Integer.parseInt(number) < NEGATIVE_STANDARD_NUMBER) {
            throw new RuntimeException(ERROR_STRING_HAS_NOT_NEGATIVE_NUMBER_MESSAGE);
        }

        int numberLength = number.length();
        for (int i = 0; i < numberLength; i++) {
            validateDigit(number.charAt(i));
        }
    }

    private static void validateDigit(char partOfNumber) {
        if (!Character.isDigit(partOfNumber)) {
            throw new RuntimeException(ERROR_STRING_IS_NOT_NUMBER_MESSAGE);
        }
    }

}
