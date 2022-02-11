package racingcar.validator;

public class Validator {

	private static final String ATTEMPT_NUMBER_TYPE_ERROR_MESSAGE = "시도 횟수는 숫자여야 합니다.";
	private static final String INTEGER_REGEX = "-?\\d+";

	public static void ofIntegerInput(String input) {
		if (!input.matches(INTEGER_REGEX)) {
			throw new IllegalArgumentException(ATTEMPT_NUMBER_TYPE_ERROR_MESSAGE);
		};
	}
}
