package racingcar.util.validator;

public class CarValidator {

	private static final String INVALID_CAR_NAME_ERROR_MESSAGE = "자동차의 이름은 1~5글자여야 합니다.";
	private static final String INVALID_POSITION_ERROR_MESSAGE = "자동차의 이름은 1~5글자여야 합니다.";

	private static final int NAME_LENGTH_LIMIT = 5;
	private static final int MINIMUM_POSITION = 0;

	public static void checkNameLength(String name) {
		if (name.isEmpty() || isOverLength(name)) {
			throw new IllegalArgumentException(INVALID_CAR_NAME_ERROR_MESSAGE);
		}
	}

	private static boolean isOverLength(String name) {
		return name.length() > NAME_LENGTH_LIMIT;
	}

	public static void checkPositionRange(int position) {
		if(position < MINIMUM_POSITION) {
			throw new IllegalArgumentException(INVALID_POSITION_ERROR_MESSAGE);
		}
	}

}
