package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

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
		int sum = 0;
		for (String number : numbers) {
			int num = toInts(number);
			validateNegative(num);
			sum += num;
		}
		return sum;
	}

	private static String findCustomDelimiter(String input) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(1);
			delimiters.append("|").append(customDelimiter);
			return m.group(2);
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
