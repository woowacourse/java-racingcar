package calculator;

public class Main {
    public static void main(String[] args) {
        start();
    }

    public static int start() throws Exception {
        String expression = InputHandler.getInput();
        Calculator calculator = new Calculator();
        calculator.calculate(expression.split(" "));
    }
}
