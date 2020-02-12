package racingcar.util;

public class Validator {

	public static final int MINIMUM_LAP = 1;

	public static boolean validateNamesInput(String input) {
		if (isInvalidNames(input)) {
			return false;
		}
		return true;
	}

	private static boolean isInvalidNames(String input) {
		return input == null || !input.contains(",");
	}

	public static boolean validateLapInput(String input) {
		try {
			return MINIMUM_LAP <= Integer.parseInt(input);
		} catch (Exception e) {
			return false;
		}
	}
}
