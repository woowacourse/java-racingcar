package utils;

public class Validator {
	private static final int ZERO = 0;

	public static void validateNumber(String[] numbers) {
		for (String number : numbers) {
			if (!isNumeric(number))
				throw new RuntimeException();
		}
	}

	private static boolean isNumeric(String value) {
		boolean numeric = true;

		if (value == null) {
			return false;
		}
		try {
			Double.parseDouble(value);
		} catch (NumberFormatException e) {
			numeric = false;
		}

		return numeric;
	}
}
