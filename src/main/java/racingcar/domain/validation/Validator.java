package racingcar.domain.validation;

import racingcar.util.Constant;

public class Validator {

	public static void checkBlank(String name, String text) {
		if (name == null) {
			throw new NullPointerException(String.format(text, Constant.NULL_ERROR));
		}
		if (name.trim().equals(Constant.EMPTY)) {
			throw new IllegalArgumentException(String.format(text, Constant.EMPTY_ERROR));
		}
	}
}
