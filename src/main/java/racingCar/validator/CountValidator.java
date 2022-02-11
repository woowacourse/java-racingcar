package racingCar.validator;

import java.util.regex.Pattern;

public class CountValidator {

	public static final String EXCEPTION_NULL_MESSAGE = "1자 이상 입력해주세요.";
	public static final String EXCEPTION_NOT_NUMBER_MESSAGE = "숫자를 입력해주세요.";
	public static final String EXCEPTION_ZERO_MESSAGE = "0회 이상 입력해주세요.";

	public static void checkCountInput(String inputString) throws Exception {
		checkNull(inputString);
		checkNotNumber(inputString);
	}

	public static void checkCountIsLessThanZero(int count) throws Exception {
		if (count <= 0) {
			throw new Exception(EXCEPTION_ZERO_MESSAGE);
		}
	}

	private static void checkNull(String inputString) throws Exception {
		if (inputString == null || inputString.isEmpty()) {
			throw new Exception(EXCEPTION_NULL_MESSAGE);
		}
	}

	private static void checkNotNumber(String inputString) throws Exception {
		if (!Pattern.matches("[0-9]+", inputString)) {
			throw new Exception(EXCEPTION_NOT_NUMBER_MESSAGE);
		}
	}
}
