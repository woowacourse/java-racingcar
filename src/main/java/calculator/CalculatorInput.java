package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import calculator.domain.UserInputForm;
import calculator.utils.validator.UserInputValidator;

public class CalculatorInput {
	private static final String INPUT_MESSAGE = "입력: ";
	private static final int CUSTOM_DELIMITER_PREFIX_LENGTH = 2;

	public UserInputForm userInput() {
		String firstInput = inputFirst();
		if (UserInputValidator.isNullOrWhiteSpace(firstInput)) {
			return new UserInputForm("0");
		}
		if (UserInputValidator.isCustomDelimiter(firstInput)) {
			return new UserInputForm(extractCustomDelimiter(firstInput), CalculatorMain.sc.nextLine());
		}
		return new UserInputForm(firstInput);
	}

	private String extractCustomDelimiter(String firstInput) {
		return firstInput.substring(CUSTOM_DELIMITER_PREFIX_LENGTH);
	}

	private String inputFirst() {
		System.out.print(INPUT_MESSAGE);
		return CalculatorMain.sc.nextLine();
	}
}
