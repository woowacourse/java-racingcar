package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	final static String DEFAULT_SEPARATOR = "[,:]";
	final static String CUSTOM_PATTERN_REGEX = "//(.)\n(.*)";
	final static String NEGATIVE_NUMBER_ERROR_MESSAGE = "양수만 입력해주세요.";

	public static int splitAndSum(String input) {
		if (isBlank(input)) {
			return 0;
		}
		int[] numbers = split(input);
		verifyNumbers(numbers);
		return sum(numbers);
	}

	public static boolean isBlank(String input) {
		return input == null || input.isEmpty();
	}

	public static int sum(int[] numbers) {
		return Arrays.stream(numbers)
			.sum();
	}

	public static void verifyNumbers(int[] numbers) {
		Arrays.stream(numbers).forEach(number -> {
			if (isNegative(number)) {
				throw new RuntimeException(NEGATIVE_NUMBER_ERROR_MESSAGE);
			}
		});
	}

	public static boolean isNegative(int number) {
		return number < 0;
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
