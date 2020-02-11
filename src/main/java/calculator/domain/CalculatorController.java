package calculator.domain;

import calculator.io.UserInput;

public class CalculatorController {
	public int run() {
		return StringCalculator.run(UserInput.getInput());
	}
}
