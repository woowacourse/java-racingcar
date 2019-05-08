package calculator;

public class Calculator {
    private String[] values;

    public Calculator(String[] values) {
        this.values = values;
    }

    public double calculate() {
        double result = Double.parseDouble(values[0]);

        for (int i = 1; i < values.length - 1; i += 2) {
            result = operate(result, values[i], Double.parseDouble(values[i + 1]));
        }
        return result;
    }

    private double operate(double first, String operator, double second) {
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

    double add(double a, double b) {
        return a + b;
    }

    double subtract(double a, double b) {
        return a - b;
    }

    double multiply(double a, double b) {
        return a * b;
    }

    double divide(double a, double b) {
        return a / b;
    }
}
