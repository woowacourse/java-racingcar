package cal;

public class Calculator {
    static StringCalculator stringCalculator = new StringCalculator();

    private static int calculate(InputValues inputValues) throws ArithmeticException {
        return stringCalculator.calculate(inputValues.getInput());
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        execute(inputView);
    }

    private static void execute(InputView inputView) {
        InputValues inputValues = inputView.inputNumbers();

        try {
            System.out.println(Calculator.calculate(inputValues));
        } catch (ArithmeticException e) {
            e.printStackTrace();
            execute(inputView);
        }
    }
}
