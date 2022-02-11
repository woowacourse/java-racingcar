package racingCar.validator;

import java.util.regex.Pattern;

public class CountValidator {

	public static final String ERROR = "ERROR";

	public static void checkInputString(String inputString) throws Exception {
		checkNull(inputString);
		checkNotNumber(inputString);
	}

	public static void checkNull(String inputString) throws Exception {
		if (inputString == null || inputString.isEmpty()) {
			throw new Exception(ERROR);
		}
	}

	public static void checkNotNumber(String inputString) throws Exception {
		boolean matcher = Pattern.matches("[0-9]+", inputString);
		if (!matcher) {
			throw new Exception(ERROR);
		}
	}

	public static void checkCountIsZero(int count) throws Exception {
		if (count == 0) {
			throw new Exception(ERROR);
		}
	}
}
