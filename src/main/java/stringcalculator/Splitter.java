package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
	private static final String DEFAULT_DELIMITERS = "[,:]";
	private static final int DELIMITER_INDEX = 1;
	private static final int INPUT_INDEX = 2;
	private static final String CUSTOM_DELIMITER_PREFIX = "//";
	private static final String SPECIAL_CUSTOM_DELIMITER_PREFIX = "\\";
	private static final String SPECIAL_CUSTOM_DELIMITERS = "+*^";
	private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

	public static String[] split(String input) {
		if (isCustomInput(input)) {
			return splitCustomDelimiter(input);
		}
		return input.split(DEFAULT_DELIMITERS);
	}

	public static String[] splitCustomDelimiter(String input) {
		Matcher m = pattern.matcher(input);
		validMatchRegEx(m);
		String customDelimiter = m.group(DELIMITER_INDEX);
		if (isSpecialDelimiter(customDelimiter)) {
			return m.group(INPUT_INDEX).split(addCustomDelimiterPrefix(customDelimiter));
		}
		return m.group(INPUT_INDEX).split(customDelimiter);
	}

	private static void validMatchRegEx(Matcher m) {
		if (!m.find()) {
			throw new RuntimeException();
		}
	}

	private static boolean isSpecialDelimiter(String customDelimiter) {
		return SPECIAL_CUSTOM_DELIMITERS.contains(customDelimiter);
	}

	private static String addCustomDelimiterPrefix(String customDelimiter) {
		return SPECIAL_CUSTOM_DELIMITER_PREFIX + customDelimiter;
	}

	public static boolean isCustomInput(String input) {
		return input.startsWith(CUSTOM_DELIMITER_PREFIX);
	}
}
