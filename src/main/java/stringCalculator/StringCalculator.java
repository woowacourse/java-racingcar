package stringCalculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String expression) {
        if (isNullOrEmpty(expression)) {
            return 0;
        }
        Matcher matcher = PATTERN.matcher(expression);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] values = matcher.group(2)
                    .split(customDelimiter);
            return sumValues(values);
        }
        String[] values = expression.split(DEFAULT_DELIMITER);
        return sumValues(values);
    }

    private static boolean isNullOrEmpty(String expression) {
        return Objects.isNull(expression) || expression.isEmpty();
    }

    private static int sumValues(String[] values) {
        validateValues(values);
        return Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static void validateValues(String[] values) {
        boolean isWrongValues = Arrays.stream(values)
                .anyMatch(value -> Integer.parseInt(value) < 0);
        if (isWrongValues) {
            throw new RuntimeException();
        }
    }
}