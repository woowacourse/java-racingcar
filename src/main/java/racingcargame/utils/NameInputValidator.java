package racingcargame.utils;

import java.util.List;

public class NameInputValidator {
	private static final int MAX_NAME_LENGTH_COUNT = 5;
	private static final int MIN_NAME_LENGTH_COUNT = 1;
	private static final String COMMA = ",";
	private static final String BLANK = " ";
	private static final String NOTHING_INPUT_IN_CAR_NAMES_ERROR_MESSAGE = "[error] 입력된 자동차 이름이 없습니다.";
	private static final String HAS_BLANK_IN_NAMES_ERROR_MESSAGE = "[error] 입력한 자동차 이름에 공백이 있습니다.";
	private static final String NO_VALIDATE_NAME_LENGTH_ERROR_MESSAGE = "[error] 자동차 이름을 5자 이하로 입력해주세요.";

	private NameInputValidator() {
	}

	public static String validateCarNames(final String carNames) {
		List<String> names = checkNothingInputInCarNames(carNames);

		if (!hasBlankInNames(names) && isValidNamesLength(names)) {
			return carNames;
		}
		throw new IllegalArgumentException();
	}

	private static List<String> checkNothingInputInCarNames(final String carNames) {
		if (carNames == null) {
			throw new IllegalArgumentException(NOTHING_INPUT_IN_CAR_NAMES_ERROR_MESSAGE);
		}
		return List.of(carNames.split(COMMA));
	}

	private static boolean hasBlankInNames(final List<String> names) {
		if (names.stream().anyMatch(name -> name.contains(BLANK))) {
			throw new IllegalArgumentException(HAS_BLANK_IN_NAMES_ERROR_MESSAGE);
		}
		return false;
	}

	private static boolean isValidNamesLength(final List<String> names) {
		int count = (int)names.stream().filter(NameInputValidator::isNotValidNameLength).count();
		if (count > 0) {
			throw new IllegalArgumentException(NO_VALIDATE_NAME_LENGTH_ERROR_MESSAGE);
		}
		return true;
	}

	private static boolean isNotValidNameLength(final String name) {
		return name.length() < MIN_NAME_LENGTH_COUNT || name.length() > MAX_NAME_LENGTH_COUNT;
	}
}