package calculator;

import calculator.ui.CalculatorInput;
import calculator.ui.CalculatorOutput;
import java.util.List;
import java.util.Scanner;

import calculator.domain.UserInputForm;
import calculator.utils.FormulaStringSplitter;

public class CalculatorMain {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		CalculatorInput calculatorInput = new CalculatorInput();
		UserInputForm userInput = calculatorInput.userInput();
		List<String> numberStrings = extractNumberStrings(userInput);
		int result = StringCalculator.calculate(numberStrings);
		CalculatorOutput calculatorOutput = new CalculatorOutput(result);
		calculatorOutput.OutputResult();
	}

	private static List<String> extractNumberStrings(UserInputForm userInput) {
		if (userInput.hasCustomDelimiter()) {
			return FormulaStringSplitter.split(userInput.getCustomDelimiter(), userInput.getFormula());
		}
		return FormulaStringSplitter.split(userInput.getFormula());
	}
}
