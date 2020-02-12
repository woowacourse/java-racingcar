package stringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	private static final int ZERO = 0;
	private static final String DELIMITERS = "[:,]";

	public static int calculate(final String value) {
		if (isNullOrEmpty(value)) {
			return 0;
		}
		return calculateSum(splitByDelimiter(value));
	}

	private static int calculateSum(String[] values) {
		int calculateResult = ZERO;

		for (String number : values) {
			final int parsedNumber = Integer.parseInt(number);

			checkNegative(parsedNumber);
			calculateResult += parsedNumber;
		}
		return calculateResult;
	}

	private static void checkNegative(final int parsedNumber) {
		if (parsedNumber < ZERO) {
			throw new RuntimeException();
		}
	}

	private static boolean isNullOrEmpty(final String value) {
		return value == null || value.isEmpty();
	}

	private static String[] splitByDelimiter(final String value) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(value);

		if (m.find()) {
			final String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}
		return value.split(DELIMITERS);
	}
}
