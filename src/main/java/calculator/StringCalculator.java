package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITERS = "//(.)\n(.*)";

    public static int splitAndSum(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITERS).matcher(value);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] token = matcher.group(2).split(customDelimiter);

            return calculator(token);
        }
        String[] values = value.split(DEFAULT_DELIMITERS);
        return calculator(values);
    }

    private static int calculator(final String[] values) {
        validateAllPositive(values);
        int sum = Arrays.stream(values)
            .mapToInt(Integer::parseInt)
            .sum();
        return sum;
    }

    private static void validateAllPositive(final String[] numbers) {
        if (containsNegative(numbers)) {
            throw new RuntimeException();
        }
    }

    private static boolean containsNegative(final String[] numbers) {
        return Arrays.stream(numbers)
            .map(Integer::parseInt)
            .anyMatch(number -> number < 0);
    }
}
