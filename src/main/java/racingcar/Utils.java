package racingcar;

import java.util.Arrays;

public class Utils {
	public static final String STRING_REGEX = ",";

	public static String[] splitAndTrim(String names) {
		String[] splitNames = names.split(STRING_REGEX);
		Arrays.setAll(splitNames, i -> splitNames[i].trim());
		return splitNames;
	}
}
