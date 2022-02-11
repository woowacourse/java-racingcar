package racingcar.utils;

import java.util.regex.Pattern;

public class InputValidation {

	private final static int MAX_NAME_LENGTH = 5;
	private final static String NUMBER_PATTERN = "^[0-9]*$";

	public void validateName(final String names) {
		final String[] carNames = names.split(RacingGameMessage.CAR_NAME_DISTRIBUTOR);
		for (String carName : carNames) {
			checkNameLength(carName);
		}
	}

	private void checkNameLength(final String carName) {
		if (carName.length() > MAX_NAME_LENGTH) {
			throw new RuntimeException(RacingGameMessage.NAME_LENGTH_ERROR);
		}
	}

	public void validateRepeats(final String repeats) {
		if (!Pattern.matches(NUMBER_PATTERN, repeats)) {
			throw new RuntimeException(RacingGameMessage.REPEATS_ERROR);
		}
	}
}
