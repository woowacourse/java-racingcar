package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int DEFAULT_SET_VALUE = 0;
    private static final String IS_NOT_NUMBER = "입력은 숫자만 가능합니다";
    private static final String IS_NOT_POSITIVE = "입력은 양수만 가능합니다";

    public int calculate(final String expression) {
        if (isEmptyOrNull(expression)) {
            return DEFAULT_SET_VALUE;
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
        return Arrays.stream(tokens)
                .map(this::convertTokenIsPositiveNumber)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int convertTokenIsPositiveNumber(final String token) {
        try{
            int convertedToken = Integer.parseInt(token);
            validatePositive(convertedToken);
            return convertedToken;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(IS_NOT_NUMBER);
        }
    }

    private void validatePositive(int convertedToken) {
        if(convertedToken < 0){
            throw new IllegalArgumentException(IS_NOT_POSITIVE);
        }
    }


}
