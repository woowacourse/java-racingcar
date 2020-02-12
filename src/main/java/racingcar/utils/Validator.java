package racingcar.utils;

public class Validator {
	private static final int maxLengthOfName = 5;

	public static boolean isValidLengthOfName(String name) {
		return name.length() <= maxLengthOfName;
	}
}
