package calculator;

import calculator.exceptions.NegativeFoundRuntimeException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final Pattern CUSTOM_DELIMITER_REGEX = Pattern.compile("//(.)\\n(.*)");

    private StringCalculator() {
        throw new IllegalStateException("StringCalculator is an utility class");
    }

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        Matcher matcher = CUSTOM_DELIMITER_REGEX.matcher(input);
        if (matcher.find()) {
            return calculate(matcher.group(2), DEFAULT_DELIMITERS + "|" + matcher.group(1));
        }
        return calculate(input, DEFAULT_DELIMITERS);
    }

    private static int calculate(String input, String delimiter) {
        String[] numbers = input.split(delimiter);
        validateAllPositive(numbers);
        return addAll(numbers);
    }

    private static void validateAllPositive(String[] numbers) {
        if (containsNegative(numbers)) {
            throw new NegativeFoundRuntimeException("found negative number(s)");
        }
    }

    private static boolean containsNegative(String[] numbers) {
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
