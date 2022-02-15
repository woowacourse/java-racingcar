package racingcar.domain.validation;

import racingcar.util.Constant;

public class CarValidator extends Validator {

	public static void carValid(String name) {
		checkBlank(name, Constant.CAR_BLANK_ERROR_MESSAGE);
		validLength(name);
	}

	private static void validLength(String name) {
		if (!(name.trim().length() <= Constant.CAR_LENGTH_LIMIT)) {
			throw new IllegalArgumentException(Constant.CAR_NAME_LENGTH_ERROR_MESSAGE);
		}
	}
}
