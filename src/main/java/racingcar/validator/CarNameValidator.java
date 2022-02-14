package racingcar.validator;

public class CarNameValidator {
	public static final String ERROR_EMPTY_NAME = "[ERROR] 빈 이름이 있습니다.";
	public static final String ERROR_LONG_NAME = "[ERROR] 이름을 5자 이하로 등록해주세요";

	public static final int NAME_LENGTH_LIMIT = 5;

	public static void validateName(String name) {
		checkEmptyName(name);
		checkLongName(name);
	}

	private static void checkEmptyName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(ERROR_EMPTY_NAME);
		}
	}

	private static void checkLongName(String name) {
		if (name.length() > NAME_LENGTH_LIMIT) {
			throw new IllegalArgumentException(ERROR_LONG_NAME);
		}
	}
}
