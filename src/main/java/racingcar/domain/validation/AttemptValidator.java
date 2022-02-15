package racingcar.domain.validation;

import racingcar.util.Constant;

public class AttemptValidator extends Validator {


	public static void attemptValid(String attempt) {
		checkBlank(attempt, Constant.ATTEMPT_BLANK_ERROR_MESSAGE);

		if (!isNumber(attempt)) {
			throw new IllegalArgumentException(Constant.ATTEMPT_NUMERIC_ERROR_MESSAGE);
		}
		if (isNegative(attempt)) {
			throw new IllegalArgumentException(Constant.ATTEMPT_NEGATIVE_ERROR_MESSAGE);
		}
	}

	private static boolean isNumber(String string) {
		return string.matches(Constant.NUMBER_REGEX);
	}

	private static boolean isNegative(String attempt) {
		return Integer.parseInt(attempt) <= 0;
	}

}