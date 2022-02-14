package stringcalculator;

import java.util.Arrays;

public class StringCalculator {
    private static final String POSITIVE_NUMBER_REGEX = "^[0-9]";
    private static final String CUSTOM_DELIMITER_AND_EXPRESSION_DELIMITER = "\n";
    private static final String DEFAULT_DELIMITER = ",|:";

    public int calculate(final String expression) {
        if (isEmptyOrNull(expression)) {
            return 0;
        }
        String[] numbers = splitExpression(expression);
        return Arrays.stream(parseToInts(numbers))
                .sum();
    }

    private boolean isEmptyOrNull(String expression) {
        return expression == null || expression.isEmpty();
    }

    private String[] splitExpression(String expression) {
        if (expression.startsWith("//")) {
            int customDelimiterIndex = 0;
            int expressionIndex = 1;
            String[] customDelimiterAndExpression = expression.split(CUSTOM_DELIMITER_AND_EXPRESSION_DELIMITER);
            String customDelimiter = customDelimiterAndExpression[customDelimiterIndex].substring(2);
            return customDelimiterAndExpression[expressionIndex].split(customDelimiter);
        }
        return expression.split(DEFAULT_DELIMITER);
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
