package calculator;

public class CalculatorMain {
    public static void main(String[] args) {
        int result = run();

        CalculatorOutput calculatorOutput = new CalculatorOutput(result);
        calculatorOutput.OutputResult();
    }

    public static int run() {
        CalculatorInput calculatorInput = new CalculatorInput();
        try {
            return StringCalculator.calculate(calculatorInput.userInput());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return run();
        }
    }
}
