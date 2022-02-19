package racingcar.util.validator;

public class AttemptValidator {

	private static final String ATTEMPT_NUMBER_TYPE_ERROR_MESSAGE = "시도 횟수는 숫자여야 합니다.";
	private static final String ATTEMPT_NUMBER_RANGE_ERROR_MESSAGE = "시도 횟수는 1회 이상이어야 합니다.";

	private static final int MINIMUM_ATTEMPT_NUMBER = 1;
	private static final String INTEGER_REGEX = "-?\\d+";

	public static void check(String input) {
		if (!input.matches(INTEGER_REGEX)) {
			throw new IllegalArgumentException(ATTEMPT_NUMBER_TYPE_ERROR_MESSAGE);
		}
		if (Integer.parseInt(input) < MINIMUM_ATTEMPT_NUMBER) {
			throw new IllegalArgumentException(ATTEMPT_NUMBER_RANGE_ERROR_MESSAGE);
		}
	}
}
