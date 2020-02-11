import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	public static int calculate(final String value) {
		if (isNullOrEmpty(value)) {
			return 0;
		}
		return sum(splitByDelimiter(value));
	}

	private static int sum(String[] values) {
		int result = 0;

		for (String number : values) {
			result += Integer.parseInt(number);
		}
		return result;
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
		return value.split("[:,]");
	}
}
