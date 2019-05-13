package cal;

public class Calculator {
    private static StringCalculator stringCalculator = new StringCalculator();

    public static void main(String[] args) {
        execute();
    }

    private static int calculate(InputValues inputValues) throws ArithmeticException {
        return stringCalculator.calculate(inputValues.getInput());
    }

    private static void execute() {
        InputValues inputValues = InputView.inputNumbers();

        try {
            System.out.println(Calculator.calculate(inputValues));
        } catch (ArithmeticException e) {
            e.printStackTrace();
            execute();
        }
    }
}
