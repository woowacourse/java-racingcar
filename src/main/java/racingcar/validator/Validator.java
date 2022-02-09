package racingcar.validator;

public class Validator {

	private static final String EMPTY_CAR_NAME_ERROR_MESSAGE = "자동차의 이름은 1글자 이상이어야 합니다.";
	private static final String INVALID_CAR_NAME_ERROR_MESSAGE = "자동차의 이름은 5글자 이하여야 합니다.";
	private static final String CAR_COUNT_LIMIT_ERROR_MESSAGE = "자동차는 2대 이상이어야 합니다";

	private static final int NAME_LENGTH_LIMIT = 5;
	private static final int CAR_COUNT_LIMIT = 2;
	private static final String SEPARATOR_OF_CAR_NAME = ",";

	public static void ofCarName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_CAR_NAME_ERROR_MESSAGE);
		}
		if (name.length() > NAME_LENGTH_LIMIT) {
			throw new IllegalArgumentException(INVALID_CAR_NAME_ERROR_MESSAGE);
		}
	}

	public static void ofCarCount(String input) {
		if (input.split(SEPARATOR_OF_CAR_NAME).length < CAR_COUNT_LIMIT) {
			throw new IllegalArgumentException(CAR_COUNT_LIMIT_ERROR_MESSAGE);
		}
	}
}
