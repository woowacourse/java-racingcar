package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
	private static final String COLON_DELIMITER = ":";
	private static final String CUSTOM_DELIMITER_PATTERN = "^//(.)\\\n.+";

	public static String getDelimiter(String input) {
		if (checkCustomDelimiter(input)) {
			return getCustomDelimiter(input);
		}
		return COLON_DELIMITER;
	}

	private static boolean checkCustomDelimiter(String input) {
		return input.matches(CUSTOM_DELIMITER_PATTERN);
	}

	private static String getCustomDelimiter(String input) {
		Pattern p = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
		Matcher m = p.matcher(input);
		m.find();

		return m.group(1);
	}
}
