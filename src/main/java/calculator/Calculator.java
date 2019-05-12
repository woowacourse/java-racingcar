package calculator;

public class Calculator {
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

    double calculate(double a, String operator, double b) throws Exception {
        if (operator.equals("+")) {
            return add(a, b);
        }
        if (operator.equals("-")) {
            return subtract(a, b);
        }
        if (operator.equals("*")) {
            return multiply(a, b);
        }
        if (operator.equals("/")) {
            return divide(a, b);
        }

        throw new IllegalArgumentException("올바른 연산자가 아닙니다.");
    }

    double calculateAll(String[] inputs) throws Exception {
        if (inputs.length % 2 == 0) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        double result = Double.parseDouble(inputs[0]);
        for (int i = 1; i < inputs.length; i += 2) {
            result = calculate(result, inputs[i], Double.parseDouble(inputs[i + 1]));
        }
        return result;
    }
}
