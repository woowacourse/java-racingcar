package racingcar.domain.validation;

public class AttemptValidator extends Validator {
	private static final String ATTEMPT_NUMERIC_ERROR_MESSAGE = "시도횟수는 숫자를 입력해주세요.";
	private static final String ATTEMPT_NEGATIVE_ERROR_MESSAGE = "시도횟수는 1이상의 수를 입력해주세요.";
	private static final String ATTEMPT_BLANK_ERROR_MESSAGE = "반복 횟수는 %s일 수 없습니다.";
	private static final String NUMBER_REGEX = "[+-]?\\d*(\\.\\d+)?";

	private boolean isNumber(String string) {
		return string.matches(NUMBER_REGEX);
	}

	private boolean isNegative(String attempt) {
		return Integer.parseInt(attempt) <= 0;
	}

	public void attemptValid(String attempt) {
		checkBlank(attempt, ATTEMPT_BLANK_ERROR_MESSAGE);

		if (!isNumber(attempt)) {
			throw new IllegalArgumentException(ATTEMPT_NUMERIC_ERROR_MESSAGE);
		}
		if (isNegative(attempt)) {
			throw new IllegalArgumentException(ATTEMPT_NEGATIVE_ERROR_MESSAGE);
		}
	}
}