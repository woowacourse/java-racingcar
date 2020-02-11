package tdd.calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUtils {
	private static final String DELIMITER = ",|:";
	private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

	public static String[] splitValues(final String value) {
		final Matcher matcher = PATTERN.matcher(value);
		if (hasCustomDelimiter(matcher)) {
			final String customValue = matcher.group(2);
			final String customDelimiter = customDelimiter(matcher);
			return customValue.split(customDelimiter);
		}
		return value.split(DELIMITER);
	}

	private static boolean hasCustomDelimiter(final Matcher matcher) {
		return matcher.find();
	}

	private static String customDelimiter(final Matcher matcher) {
		return DELIMITER + "|" + matcher.group(1);
	}
}

