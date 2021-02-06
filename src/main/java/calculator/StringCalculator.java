package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int EMPTY_RESULT = 0;
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final int FIRST_MATCH = 1;
    private static final int SECOND_MATCH = 2;
    private static final String DEFAULT_DELIMITER_PATTERN = "[,:]";
    private static final int ALLOWED_MIN_NUMBER = 0;

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return EMPTY_RESULT;
        }

        return getSplitNumbersSum(input);
    }

    private static int getSplitNumbersSum(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(FIRST_MATCH);
            return validateAndSumNumbers(m.group(SECOND_MATCH).split(customDelimiter));
        }

        return validateAndSumNumbers(input.split(DEFAULT_DELIMITER_PATTERN));
    }

    private static int validateAndSumNumbers(String[] values) {
        if (Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .anyMatch(number -> number < ALLOWED_MIN_NUMBER)) {
            throw new RuntimeException();
        }

        return Arrays.stream(values).mapToInt(Integer::parseInt).sum();
    }
}
