package calculator;

public class Calculator {
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

    int calculate(int a, String operator, int b) {
        if (operator == "+") {
            return add(a,b);
        }
        if (operator == "-") {
            return subtract(a,b);
        }
        if (operator == "*") {
            return multiply(a,b);
        }
        if (operator == "/") {
            return divide(a,b);
        }

        return -1;
    }
}
