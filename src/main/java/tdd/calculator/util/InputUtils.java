package tdd.calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUtils {
	private static final String DELIMITER = ",|:";
	private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
	private static final int VALUE_INDEX = 2;
	private static final int DELIMITER_INDEX = 1;
	private static final String CONCATENATOR = "|";

	public static String[] split(final String value) {
		final Matcher matcher = PATTERN.matcher(value);
		if (hasCustomDelimiter(matcher)) {
			final String customValue = matcher.group(VALUE_INDEX);
			final String customDelimiter = buildCustomDelimiter(matcher);
			return customValue.split(customDelimiter);
		}
		return value.split(DELIMITER);
	}

	private static boolean hasCustomDelimiter(final Matcher matcher) {
		return matcher.find();
	}

	private static String buildCustomDelimiter(final Matcher matcher) {
		final String additionalDelimiter = matcher.group(DELIMITER_INDEX);
		return DELIMITER + CONCATENATOR + additionalDelimiter;
	}
}

