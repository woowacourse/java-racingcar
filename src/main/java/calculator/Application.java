package calculator;

import calculator.domain.Delimiter;
import calculator.domain.Numbers;
import calculator.domain.StringAdditionCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
	public static final String START_CHARACTER = "//";
	private static final int FIRST_INDEX = 0;
	private static final int END_INDEX = 2;

	public static void main(String[] args) {
		OutputView.showInputRequest();
		String input = InputView.receiveInput();
		Delimiter delimiter = new Delimiter(input);

		if (START_CHARACTER
			.equals(input.substring(FIRST_INDEX, END_INDEX))) {
			input = InputView.receiveInput();
		}

		Numbers numbers = new Numbers(input, delimiter.getDelimiter());

		StringAdditionCalculator stringAdditionCalculator = new StringAdditionCalculator();
		int result = stringAdditionCalculator.calculate(numbers.getNumbers());

		OutputView.showResult(result);
	}
}
