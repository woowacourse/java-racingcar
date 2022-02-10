package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	public static int add(String input) {
		if (input == null || input.equals("")) {
			return 0;
		}
		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
		if (matcher.find()) {
			return splitByCustomDivider(matcher);
		}
		String[] numbers = input.split(",|:");
		return sum(numbers);
	}

	public static int splitByCustomDivider(Matcher matcher) {
		String customDivider = matcher.group(1);
		String[] numbers = matcher.group(2).split(customDivider + "|,|:");
		return sum(numbers);
	}

	public static int sum(String[] numbers) {
		int result = 0;
		for (String number : numbers) {
			checkNonNumber(number);
			checkNegativeNumber(number);
			result += Integer.parseInt(number);
		}
		return result;
	}

	public static void checkNonNumber(String number) {
		try {
			Integer.parseInt(number);
		} catch (Exception e) {
			throw new RuntimeException("숫자가 아닌 값은 더할 수 없습니다.");
		}
	}

	public static void checkNegativeNumber(String number) {
		if (Integer.parseInt(number) < 0) {
			throw new RuntimeException("음수는 허용되지 않습니다.");
		}
	}

}
