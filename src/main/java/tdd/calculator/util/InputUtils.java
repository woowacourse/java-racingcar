package tdd.calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUtils {
	private static final String DELIMITER = ",|:";
	private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
	private static final int VALUE_INDEX = 2;
	private static final int DELIMITER_INDEX = 1;
	private static final String CONCATENATOR = "|";

	private InputUtils() {}

	public static String[] split(final String value) {
		final Matcher matcher = PATTERN.matcher(value);
		final boolean hasCustomDelimiter = matcher.find();
		if (hasCustomDelimiter) {
			final String customValue = matcher.group(VALUE_INDEX);
			final String customDelimiter = matcher.group(DELIMITER_INDEX);
			return customValue.split(DELIMITER + CONCATENATOR + customDelimiter);
		}
		return value.split(DELIMITER);
	}
}

