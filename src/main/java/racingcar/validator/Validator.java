package racingcar.validator;

public class Validator {

	private static final String EMPTY_CAR_NAME_ERROR_MESSAGE = "자동차의 이름은 1글자 이상이어야 합니다.";
	private static final String INVALID_CAR_NAME_ERROR_MESSAGE = "자동차의 이름은 5글자 이하여야 합니다.";
	private static final int NAME_LENGTH_LIMIT = 5;

	public static void ofCarName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_CAR_NAME_ERROR_MESSAGE);
		}
		if (name.length() > NAME_LENGTH_LIMIT) {
			throw new IllegalArgumentException(INVALID_CAR_NAME_ERROR_MESSAGE);
		}
	}
}
