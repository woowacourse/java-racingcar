package calculator;

import java.util.Scanner;

public class CalculatorMain {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		CalculatorInput calculatorInput = new CalculatorInput();
		int result = StringCalculator.calculate(calculatorInput.userInput());
		CalculatorOutput calculatorOutput = new CalculatorOutput(result);
		calculatorOutput.OutputResult();
	}
}
