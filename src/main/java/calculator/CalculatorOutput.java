package calculator;

public class CalculatorOutput {
    private static final String RESULT_MESSAGE = "결과값: ";

    public static void printResult(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }

    public static void printErrorMessage(String error) {
        System.out.println(error);
    }
}
