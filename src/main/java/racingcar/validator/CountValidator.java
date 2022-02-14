package racingcar.validator;

import java.util.regex.Pattern;

public class CountValidator {

	private static final String NUMBER_REGEX = "[0-9]+";
	private static final int COUNT_ZERO_CRITERIA = 0;
	private static final String COUNT_NULL_ERROR_MSG = "시도할 횟수가 입력되지 않았습니다.";
	private static final String COUNT_NOT_INTEGER_MSG = "숫자가 아닌 값이 입력되었습니다.";
	private static final String COUNT_ZERO_ERROR_MSG = "0회 이하는 게임을 진행할 수 없습니다.";

	public static void checkInputString(String inputString) {
		checkNull(inputString);
		checkNotNumber(inputString);
	}

	private static void checkNull(String inputString) {
		if (inputString == null || inputString.isEmpty()) {
			throw new IllegalArgumentException(COUNT_NULL_ERROR_MSG);
		}
	}

	private static void checkNotNumber(String inputString) {
		if (!Pattern.matches(NUMBER_REGEX, inputString)) {
			throw new NumberFormatException(COUNT_NOT_INTEGER_MSG);
		}
	}

	public static void checkCountIsZero(int count) {
		if (count == COUNT_ZERO_CRITERIA) {
			throw new IllegalArgumentException(COUNT_ZERO_ERROR_MSG);
		}
	}
}
