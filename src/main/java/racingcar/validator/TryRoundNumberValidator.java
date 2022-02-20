package racingcar.validator;

public class TryRoundNumberValidator {

	public static final String INVALID_NOT_NUMBER = "[ERROR] 시행횟수가 숫자가 아닙니다";
	public static final String INVALID_NOT_POSITIVE_NUMBER = "[ERROR] 시행횟수는 0보다 큰 숫자여야 합니다";

	public static void validateNumber(final String input) {
		isNumber(input);
		isPositiveNumber(input);
	}

	private static void isNumber(final String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new RuntimeException(INVALID_NOT_NUMBER);
		}
	}

	private static void isPositiveNumber(final String input) {
		if (Integer.parseInt(input) <= 0) {
			throw new RuntimeException(INVALID_NOT_POSITIVE_NUMBER);
		}
	}
}
