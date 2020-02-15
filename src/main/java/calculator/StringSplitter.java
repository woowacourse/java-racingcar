package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {
	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
	private static final String BASIC_DELIMITER = ",|:";
	private static final int CUSTOM_DELIMITER_GROUP_INDEX = 1;
	private static final int ELEMENTS_GROUP_INDEX = 2;

	public static String[] split(String input) {
		Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(CUSTOM_DELIMITER_GROUP_INDEX);
			return m.group(ELEMENTS_GROUP_INDEX).split(customDelimiter);
		}
		return input.split(BASIC_DELIMITER);
	}
}
