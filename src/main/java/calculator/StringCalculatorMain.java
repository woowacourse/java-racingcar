package calculator;

public class StringCalculatorMain {
    public static void main(String[] args) {
        String input = StringCalculatorUi.getInput();
        int result = StringCalculator.splitAndSum(input);
        StringCalculatorUi.printOutput(result);
    }

}
