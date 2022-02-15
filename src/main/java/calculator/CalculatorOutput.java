package calculator;

public class CalculatorOutput {
    private static final String RESULT_MESSAGE = "결과값: ";
    private final int result;

    public CalculatorOutput(int result) {
        this.result = result;
    }

    public void OutputResult() {
        System.out.println(RESULT_MESSAGE + result);
    }

    public static void printErrorMessage(String error) {
        System.out.println(error);
    }
}
