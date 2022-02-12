package racingcar.view;

public class InputValidator {
	public static final String POSITIVE_REGEX = "^[1-9]+[0-9]*$";
	private static final String ERROR_GET_POSITIVE_MESSAGE = "양수를 입력해주세요.";
	private static final String ERROR_GET_NOT_EMPTY_MESSAGE = "빈 값을 입력하셨습니다. 양수를 입력해주세요.";

	public static void validIterationNo(String input) {
		validEmptyInput(input);
		validPositiveInput(input);
	}

	private static void validPositiveInput(String input) {
		if (!input.matches(POSITIVE_REGEX)) {
			throw new RuntimeException(ERROR_GET_POSITIVE_MESSAGE);
		}
	}

	private static void validEmptyInput(String input) {
		if (input == null || input.isEmpty()) {
			throw new RuntimeException(ERROR_GET_NOT_EMPTY_MESSAGE);
		}
	}
}
