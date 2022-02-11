package racingCar.validator;

import java.util.regex.Pattern;

import racingCar.utlis.Constants;

public class CountValidator {

	public static void validateInput(String inputString) throws Exception {
		checkNull(inputString);
		checkNotNumber(inputString);
	}

	public static void validateInteger(int count) throws Exception {
		if (count <= 0) {
			throw new Exception(Constants.EXCEPTION_ZERO_MESSAGE);
		}
	}

	private static void checkNull(String inputString) throws Exception {
		if (inputString == null || inputString.isEmpty()) {
			throw new Exception(Constants.EXCEPTION_NULL_MESSAGE);
		}
	}

	private static void checkNotNumber(String inputString) throws Exception {
		if (!Pattern.matches("[0-9]+", inputString)) {
			throw new Exception(Constants.EXCEPTION_NOT_NUMBER_MESSAGE);
		}
	}
}
