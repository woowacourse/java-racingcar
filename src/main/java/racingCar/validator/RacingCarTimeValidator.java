package racingCar.validator;

import static racingCar.constants.RacingCarConstants.*;

public class RacingCarTimeValidator {

	public static void isRightTimes(String input) throws RuntimeException {
		final String REGEX = "[0-9]+";
		if (!input.matches(REGEX)) {
			throw new RuntimeException(GAME_COUNT_POSITIVE_INTEGER_ERROR);
		}
	}
}
