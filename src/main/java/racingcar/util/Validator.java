package racingcar.util;

public class Validator {
	public static boolean validate(String input) {
		if (isInvalid(input)) {
			return false;
		}
		return true;
	}

	private static boolean isInvalid(String input) {
		return input == null || !input.contains(",");
	}
}
