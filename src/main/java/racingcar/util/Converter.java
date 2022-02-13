package racingcar.util;

import racingcar.validator.InputValidator;

public class Converter {

	private static final String SEPARATOR_OF_CAR_NAME = ",";

	public static int toAttemptNumber(String input) {
		InputValidator.ofAttemptNumber(input);
		return Integer.parseInt(input);
	}
}
