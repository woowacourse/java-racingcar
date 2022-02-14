package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
	public static final int CUSTOM_DELIMITER_GROUP = 1;
	public static final int INPUT_STRING_GROUP = 2;

	private static final StringBuilder delimiters = new StringBuilder(",|:");

	public static int splitAndSum(String input) {
		if (isNullOrEmpty(input)) {
			return 0;
		}

		List<String> numbers = split(input);
		int sum = addAllNumber(numbers);
		return sum;
	}

	private static boolean isNullOrEmpty(String input) {
		return input == null || input.isEmpty();
	}

	private static List<String> split(String input) {
		input = findCustomDelimiter(input);
		return Arrays.asList(input.split(delimiters.toString()));
	}

	private static int addAllNumber(List<String> numbers) {
		return numbers.stream().mapToInt(number -> {
			int intValue = toInts(number);
			validateNegative(intValue);
			return intValue;
		}).sum();
	}

	private static String findCustomDelimiter(String input) {
		Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(CUSTOM_DELIMITER_GROUP);
			delimiters.append("|").append(customDelimiter);
			return m.group(INPUT_STRING_GROUP);
		}
		return input;
	}

	private static int toInts(String number) {
		return Integer.parseInt(number);
	}

	private static void validateNegative(int num) {
		if (num < 0) {
			throw new IllegalArgumentException("음수는 허용되지 않습니다.");
		}
	}
}
