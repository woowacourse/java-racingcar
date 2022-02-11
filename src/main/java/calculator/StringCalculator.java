package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public static int splitAndSum(String text) {
		if (text == null || text.isEmpty()) {
			return 0;
		}
		return sum(split(text));
	}

	private static String[] split(String text) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}
		return text.split(",|:");
	}

	private static int sum(String[] tokens) {
		int result = 0;
		int number;
		for (String token : tokens) {
			number = Integer.parseInt(token);
			validateNegative(number);
			result += number;
		}
		return result;
	}

	private static void validateNegative(int number) {
		if (number < 0) {
			throw new RuntimeException();
		}
	}
}
