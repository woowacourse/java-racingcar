package calculator;

import calculator.domain.vo.Expression;

public class Calculator {

    private static final int ZERO = 0;

    public static int sum(String input) {
        if (validateNullOrEmpty(input)) {
            return ZERO;
        }
        Expression expression = new Expression(input);
        return expression.sum();
    }

    private static boolean validateNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
