package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final Pattern CUSTOM_DELIMITERS = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(final String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }
        Matcher matcher = CUSTOM_DELIMITERS.matcher(value);
        if (matcher.find()) {
            return calculator(matcher.group(2), DEFAULT_DELIMITERS + "|" + CUSTOM_DELIMITERS);
        }
        return calculator(value, DEFAULT_DELIMITERS);
    }

    private static int calculator(final String input, final String delimiters) {
        final String[] numbers = input.split(delimiters);
        validateAllPositive(numbers);
        return addAll(numbers);
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

    private static int addAll(String[] numbers) {
        return Arrays.stream(numbers)
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
