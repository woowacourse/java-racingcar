package calculator;

import calculator.ui.CalculatorInput;
import calculator.ui.CalculatorOutput;

public class CalculatorMain {
    public static void main(String[] args) {
        int result = run();

        CalculatorOutput.printResult(result);
    }

    public static int run() {
        StringCalculator stringCalculator = new StringCalculator();
        try {
            return stringCalculator.calculate(CalculatorInput.userInput());
        } catch (RuntimeException e) {
            CalculatorOutput.printErrorMessage(e.getMessage());
            return run();
        }
    }
}
