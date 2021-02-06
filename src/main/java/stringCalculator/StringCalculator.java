package stringCalculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    public static int splitAndSum(String expression) {
        if (isNullOrEmpty(expression)) {
            return ZERO;
        }
        Matcher matcher = PATTERN.matcher(expression);
        if (matcher.find()) {
            String[] values = splitValuesByCustomDelimiter(matcher);
            return sumValues(values);
        }
        String[] values = splitValuesByDefaultDelimiter(expression);
        return sumValues(values);
    }

    private static boolean isNullOrEmpty(String expression) {
        return Objects.isNull(expression) || expression.isEmpty();
    }

    private static String[] splitValuesByCustomDelimiter(Matcher matcher) {
        String customDelimiter = matcher.group(ONE);
        return matcher.group(TWO)
                .split(customDelimiter);
    }

    private static int sumValues(String[] values) {
        validateValues(values);
        return Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static void validateValues(String[] values) {
        boolean isWrongValues = Arrays.stream(values)
                .anyMatch(value -> Integer.parseInt(value) < ZERO);
        if (isWrongValues) {
            throw new RuntimeException();
        }
    }

    private static String[] splitValuesByDefaultDelimiter(String expression) {
        return expression.split(DEFAULT_DELIMITER);
    }
}
