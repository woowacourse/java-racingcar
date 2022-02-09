package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	final static String DEFAULT_SEPARATOR = "[,:]";
	final static String CUSTOM_PATTERN_REGEX = "//(.)\n(.*)";

	public static int splitAndSum(String input) {
		if (isBlank(input)) {
			return 0;
		}

		return sum(split(input));
	}

	public static boolean isBlank(String input) {
		return input == null || input.isEmpty();
	}

	public static int sum(int[] numbers) {
		return Arrays.stream(numbers)
			.sum();
	}

	public static int[] split(String input) {
		Matcher matcher = createMatcher(input);
		if (matcher.find()) {
			return splitByCustomSeparator(matcher);
		}

		return splitByDefaultSeparator(input);
	}

	public static Matcher createMatcher(String input) {
		return Pattern.compile(CUSTOM_PATTERN_REGEX).matcher(input);
	}

	public static int[] splitByDefaultSeparator(String input) {
		return Arrays.stream(input.split(DEFAULT_SEPARATOR))
			.mapToInt(Integer::parseInt)
			.toArray();
	}

	public static int[] splitByCustomSeparator(Matcher matcher) {
		String customDelimiter = matcher.group(1);
		String[] tokens = matcher.group(2).split(customDelimiter);
		return Arrays.stream(tokens)
			.mapToInt(Integer::parseInt)
			.toArray();
	}
}
