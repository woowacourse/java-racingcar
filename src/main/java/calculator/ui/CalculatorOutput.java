package calculator.ui;

public class CalculatorOutput {
    private static final String RESULT_MESSAGE = "결과값: ";

    public static void printResult(final int result) {
        System.out.println(RESULT_MESSAGE + result);
    }

    public static void printErrorMessage(final String error) {
        System.out.println(error);
    }
}
