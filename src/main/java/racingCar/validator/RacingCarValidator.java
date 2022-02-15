package racingCar.validator;

import static racingCar.constants.RacingCarConstants.*;

public class RacingCarValidator {
	public static void isRightLength(String name) throws RuntimeException {
		if (name.length() == 0 || name.length() > 5) {
			throw new RuntimeException(CAR_NAME_WRONG_LENGTH_ERROR);
		}
	}

	public static void isRightTimes(String input) throws RuntimeException {
		final String REGEX = "[0-9]+";
		if (!input.matches(REGEX)) {
			throw new RuntimeException(GAME_COUNT_POSITIVE_INTEGER_ERROR);
		}
	}
}
