package calculator;

public class CalculatorMain {
	public static void main(String[] args) {
		CalculatorInput calculatorInput = new CalculatorInput();
		int result = StringCalculator.calculate(calculatorInput.userInput());
		CalculatorOutput calculatorOutput = new CalculatorOutput(result);
		calculatorOutput.OutputResult();
	}
}
