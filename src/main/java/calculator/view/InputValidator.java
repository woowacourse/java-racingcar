package calculator.view;

public class InputValidator {
    private static final String NUMBER_REGEX = "-?[0-9]*";
    private static final String PLUS_OPERATOR = "+";
    private static final String MINUS_OPERATOR = "-";
    private static final String MULTIPLY_OPERATOR = "*";
    private static final String DIVIDE_OPERATOR = "/";

    public static boolean isValid(String[] values) {
        if (!isNumber(values[0]) || !isNumber(values[values.length - 1])) {
            return false;
        }
        return isRightSequence(values);
    }

    public static boolean isRightSequence(String[] values) {
        int index = 0;
        while (index < values.length && isOperatorOrNumberByIndex(values, index)) {
            index++;
        }
        return !(index < values.length);
    }

    public static boolean isOperatorOrNumberByIndex(String[] values, int index) {
        if (index % 2 == 0) {
            return isNumber(values[index]);
        }
        return isOperator(values[index]);
    }

    public static boolean isNumber(String value) {
        return value.matches(NUMBER_REGEX);
    }

    public static boolean isOperator(String value) {
        return (value.equals(PLUS_OPERATOR))
                || (value.equals(MINUS_OPERATOR))
                || (value.equals(MULTIPLY_OPERATOR))
                || (value.equals(DIVIDE_OPERATOR));
    }
}
