package stringcalculator;

public class Calculator {

    public int calculate(String[] inputText) {
        int sum = parseStringToInt(inputText[0]);
        int rightValue;
        String operator;

        for (int i = 1; i < inputText.length ; i += 2) {
            rightValue = parseStringToInt(inputText[i + 1]);
            operator = inputText[i];
            sum = excuteOperation(sum, rightValue, operator);
        }

        return sum;
    }

    private int parseStringToInt(String target) {
        return Integer.parseInt(target);
    }

    private int excuteOperation(int leftValue, int rightValue, String operator) {
        if (operator.equals("+")) {
            return plus(leftValue, rightValue);
        }

        if (operator.equals("-")) {
            return minus(leftValue, rightValue);
        }

        if (operator.equals("*")) {
            return multiply(leftValue, rightValue);
        }

        if (operator.equals("/")) {
            return divide(leftValue, rightValue);
        }

        return  0;
    }

    private int plus(int leftValue, int rightValue) {
        return leftValue + rightValue;
    }

    private int minus(int leftValue, int rightValue) {
        return leftValue - rightValue;
    }

    private int multiply(int leftValue, int rightValue) {
        return leftValue * rightValue;
    }

    private int divide(int leftValue, int rightValue) {
        return leftValue / rightValue;
    }
}
