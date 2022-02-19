package racingcar.util.validator;

public class InputValidator {

	private static final String EMPTY_CAR_NAME_ERROR_MESSAGE = "자동차 이름이 입력되지 않았습니다.";
	private static final String EMPTY_ATTEMPT_NUMBER_ERROR_MESSAGE = "시도 횟수가 입력되지 않았습니다.";

	public static void checkCarNames(String carNamesInput) {
		if (carNamesInput.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_CAR_NAME_ERROR_MESSAGE);
		}
	}

	public static void checkAttemptNumber(String carNamesInput) {
		if (carNamesInput.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_ATTEMPT_NUMBER_ERROR_MESSAGE);
		}
	}
}
