package racingCar.validator;

import static racingCar.constants.RacingCarConstants.*;

public class RacingCarNameValidator {

	public static void isRightInput(String input) throws RuntimeException {
		if (!input.matches(CAR_NAME_PATTERN_REGEX)) {
			throw new RuntimeException(CAR_NAME_WRONG_INPUT_ERROR);
		}
	}

	public static void isRightLength(String name) throws RuntimeException {
		if (name.isEmpty() || name.length() > 5) {
			throw new RuntimeException(CAR_NAME_WRONG_LENGTH_ERROR);
		}
	}
}
