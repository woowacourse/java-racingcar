package racingcar;

import java.util.Arrays;

public class Utils {
	public static final String STRING_REGEX = ",";
	public static final String ERROR_NOT_INTEGER = "[ERROR] 이동횟수는 숫자로 입력해야합니다.";

	public static String[] splitAndTrim(String names) {
		String[] splitNames = names.split(STRING_REGEX);
		Arrays.setAll(splitNames, i -> splitNames[i].trim());
		return splitNames;
	}

	public static int strToInt(String givenString) {
		try {
			return Integer.parseInt(givenString);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR_NOT_INTEGER);
		}
	}
}
