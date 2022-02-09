package racingcar.validator;

import java.util.Arrays;

public class Validator {

	private static final String EMPTY_CAR_NAME_ERROR_MESSAGE = "자동차의 이름은 1글자 이상이어야 합니다.";
	private static final String INVALID_CAR_NAME_ERROR_MESSAGE = "자동차의 이름은 5글자 이하여야 합니다.";
	private static final String CAR_COUNT_LIMIT_ERROR_MESSAGE = "자동차는 2대 이상이어야 합니다";
	private static final String ATTEMPT_NUMBER_TYPE_ERROR_MESSAGE = "시도 횟수는 숫자여야 합니다.";
	private static final String ATTEMPT_NUMBER_RANGE_ERROR_MESSAGE = "시도 횟수는 1회 이상이어야 합니다.";

	private static final int NAME_LENGTH_LIMIT = 5;
	private static final int CAR_COUNT_LIMIT = 2;
	private static final String SEPARATOR_OF_CAR_NAME = ",";
	private static final String INTEGER_REGEX = "-?\\d+";

	public static void ofCarNames(String input) {
		Arrays.stream(ofCarCount(input))
			.forEach(Validator::ofCarName);
	}

	private static void ofCarName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_CAR_NAME_ERROR_MESSAGE);
		}
		if (name.length() > NAME_LENGTH_LIMIT) {
			throw new IllegalArgumentException(INVALID_CAR_NAME_ERROR_MESSAGE);
		}
	}

	private static String[] ofCarCount(String input) {
		String[] split = input.split(SEPARATOR_OF_CAR_NAME);
		if (split.length < CAR_COUNT_LIMIT) {
			throw new IllegalArgumentException(CAR_COUNT_LIMIT_ERROR_MESSAGE);
		}
		return split;
	}

	public static void ofAttemptNumber(String input) {
		ofAttemptNumberType(input);
		ofAttemptNumberRange(input);
	}

	private static void ofAttemptNumberType(String input) {
		if (!input.matches(INTEGER_REGEX)) {
			throw new IllegalArgumentException(ATTEMPT_NUMBER_TYPE_ERROR_MESSAGE);
		}
	}

	private static void ofAttemptNumberRange(String input) {
		if (Integer.parseInt(input) < 1) {
			throw new IllegalArgumentException(ATTEMPT_NUMBER_RANGE_ERROR_MESSAGE);
		}
	}
}
