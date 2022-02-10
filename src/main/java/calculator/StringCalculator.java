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
		int result = 0;
		for (String number : numbers) {
			result += Integer.parseInt(number);
		}
		return result;
	}

	public static int splitByCustomDivider(Matcher matcher) {
		String customDivider = matcher.group(1);
		String[] numbers = matcher.group(2).split(customDivider + "|,|:");
		int result = 0;
		for (String number : numbers) {
			result += Integer.parseInt(number);
		}
		return result;
	}
}
