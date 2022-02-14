package racingcar.utils;

import java.util.regex.Pattern;

public class InputValidation {

	private static final String NAME_LENGTH_ERROR = "이름은 5자리 이하만 가능합니다.";
	private static final String REPEATS_ERROR = "반복횟수는 정수만 입력 가능합니다.";
	private final static int MAX_NAME_LENGTH = 5;
	private final static String NUMBER_PATTERN = "^[0-9]*$";
	private final static String CAR_NAME_DISTRIBUTOR = ",";

	public void validateName(final String names) {
		final String[] carNames = names.split(CAR_NAME_DISTRIBUTOR);
		for (String carName : carNames) {
			checkNameLength(carName);
		}
	}

	private void checkNameLength(final String carName) {
		if (carName.length() > MAX_NAME_LENGTH) {
			throw new RuntimeException(NAME_LENGTH_ERROR);
		}
	}

	public void validateRepeats(final String repeats) {
		if (!Pattern.matches(NUMBER_PATTERN, repeats)) {
			throw new RuntimeException(REPEATS_ERROR);
		}
	}
}
