package racingCar.validator;

import java.util.regex.Pattern;

public class CountValidator {

	public static final String NUMBER_REGEX = "[0-9]+";
	public static final int COUNT_ZERO_CRITERIA = 0;
	public static final String COUNT_NULL_ERROR_MSG = "시도할 횟수가 입력되지 않았습니다.";
	public static final String COUNT_NOT_INTEGER_MSG = "숫자가 아닌 값이 입력되었습니다.";
	public static final String COUNT_ZERO_ERROR_MSG = "0회 이하는 게임을 진행할 수 없습니다";

	public static void checkInputString(String inputString) throws Exception {
		checkNull(inputString);
		checkNotNumber(inputString);
	}

	public static void checkNull(String inputString) throws Exception {
		if (inputString == null || inputString.isEmpty()) {
			throw new Exception(COUNT_NULL_ERROR_MSG);
		}
	}

	public static void checkNotNumber(String inputString) throws Exception {
		boolean matcher = Pattern.matches(NUMBER_REGEX, inputString);
		if (!matcher) {
			throw new Exception(COUNT_NOT_INTEGER_MSG);
		}
	}

	public static void checkCountIsZero(int count) throws Exception {
		if (count == COUNT_ZERO_CRITERIA) {
			throw new Exception(COUNT_ZERO_ERROR_MSG);
		}
	}
}
