package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(?<delimiter>.)\n(?<numbers>.*)");
	private static final String DEFAULT_DELIMITER = ",|:";

	public static int splitAndSum(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}
		Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);
		if (m.find()) {
			return splitAndSumByCustomDelimiter(m);
		}
		return splitAndSumByDefaultDelimiter(input);
	}

	private static int splitAndSumByDefaultDelimiter(String input) {
		return sum(input.split(DEFAULT_DELIMITER));
	}

	private static int splitAndSumByCustomDelimiter(Matcher m) {
		return sum(m.group("numbers").split(m.group("delimiter")));
	}

	private static int sum(String[] values) {
		return Arrays.stream(values)
			.mapToInt(Integer::parseInt)
			.sum();
	}
}
