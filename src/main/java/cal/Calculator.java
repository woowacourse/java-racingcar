package cal;

public class Calculator {
    private static StringCalculator stringCalculator = new StringCalculator();

    private static int calculate(Numbers numbers) throws ArithmeticException {
        return stringCalculator.calculate(numbers.getInput());
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        execute(inputView);
    }

    private static void execute(InputView inputView) {
        Numbers numbers = inputView.inputNumbers();

        try {
            System.out.println(Calculator.calculate(numbers));
        } catch (ArithmeticException e) {
            e.printStackTrace();
            execute(inputView);
        }
    }
}
