package StringCalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String POSITIVE_NUMBER_REGEX = "^[0-9]";

    public int calculate(final String expression) {
        if (isEmptyOrNull(expression)) {
            return 0;
        }
        int[] numbers = splitExpression(expression);
        return Arrays.stream(numbers)
                .sum();
    }

    private boolean isEmptyOrNull(String expression) {
        return expression == null || expression.isEmpty();
    }

    private int[] splitExpression(String expression) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return parseToInts(m.group(2).split(customDelimiter));
        }
        return parseToInts(expression.split(",|:"));
    }

    private int[] parseToInts(final String[] tokens) {
        validate(tokens);
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .toArray();
    }


    private void validate(final String[] tokens) {
        if (hasContainsNotPositiveNumber(tokens)) {
            throw new RuntimeException("피연산자에 양의 정수 혹은 0이 아닌 값이 있습니다.");
        }
    }

    private boolean hasContainsNotPositiveNumber(final String[] tokens) {
        return Arrays.stream(tokens)
                .anyMatch(token -> !token.matches(POSITIVE_NUMBER_REGEX));
    }
}
