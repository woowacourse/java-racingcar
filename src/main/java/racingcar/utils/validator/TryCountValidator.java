package racingcar.utils.validator;

public class TryCountValidator {

	private static final String PATTERN = "^([1-9])([0-9])*$";
	private static final String PATTERN_ERROR_MESSAGE = "[ERROR] 시도 회수는 양수만 가능합니다.";

	private TryCountValidator() {
	}

	public static void validatePattern(final String inputValue) {
		if (!inputValue.matches(PATTERN)) {
			throw new IllegalArgumentException(PATTERN_ERROR_MESSAGE);
		}
	}
}
