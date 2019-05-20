package calculator;

public class Main {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        NumericExpression expression = InputHandler.getInput();
        Calculator calculator = new Calculator();
        calculate(expression.getExpression(), calculator);
    }

    private static void calculate(String expression, Calculator calculator) {
        try {
            calculator.calculateInput(expression);
        } catch (ArithmeticException e) {
            start();
        }
    }
}
