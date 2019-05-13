package cal;

public class Calculator {
    private static StringCalculator stringCalculator = new StringCalculator();

    private static int calculate(Expression expression) throws ArithmeticException {
        return stringCalculator.calculate(expression.getInput());
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        execute(inputView);
    }

    private static void execute(InputView inputView) {
        Expression expression = inputView.inputNumbers();

        try {
            System.out.println(Calculator.calculate(expression));
        } catch (ArithmeticException e) {
            e.printStackTrace();
            execute(inputView);
        }
    }
}
