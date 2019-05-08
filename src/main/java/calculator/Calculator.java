package calculator;

public class Calculator {
    private String[] values;

    public Calculator(String[] values) {
        this.values = values;
    }

    public int calculate() {
        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length - 1; i += 2) {
            result = operate(result, values[i], Integer.parseInt(values[i + 1]));
        }
        return result;
    }

    private int operate(int first, String operator, int second) {
        if (operator.equals("+")) {
            return add(first, second);
        }
        if (operator.equals("-")) {
            return subtract(first, second);
        }
        if (operator.equals("*")) {
            return multiply(first, second);
        }
        if (operator.equals("/")) {
            return divide(first, second);
        }

        throw new IllegalArgumentException("잘못된 계산식입니다.");
    }

    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        return a / b;
    }
}
