package calculator;

import java.util.Arrays;

public class NumericExpression {
    static final String[] operators = {"+", "-", "*", "/"};

    public NumericExpression(String input) throws Exception {
        canCalculate(input.split(" "));
    }

    public static boolean canCalculate(String[] inputs) {
        boolean isOperator = false;
        boolean result = true;

        for (int i = 0; i < inputs.length && result; i++, isOperator = !isOperator) {
            result = checkString(isOperator, inputs[i]);
        }

        return result && (inputs.length > 0) && isOperator;
    }

    public static boolean checkString(boolean isOperator, String input) {
        if (isOperator) {
            return Arrays.asList(operators).contains(input);
        }

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

}
