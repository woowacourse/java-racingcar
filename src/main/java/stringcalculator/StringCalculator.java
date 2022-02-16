package stringcalculator;

import static stringcalculator.StringCalculatorValidator.*;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	private static final String REGULAR_EXPRESSION = "//(.)\\n(.*)";

	public static int splitAndSum(String input) {

		if (input == null || input.isEmpty()) {
			return 0;
		}

		String[] numbers = getSplitNumbers(input);

		isValidNumbers(numbers);

		return getSumOfNumbers(numbers);
	}



	private static int getSumOfNumbers(String[] numbers) {
		return Arrays.stream(numbers)
			.mapToInt(Integer::parseInt)
			.sum();
	}

	private static String[] getSplitNumbers(String input) {

		boolean result = "//;\n1;2;3".matches("//(.)\\n(.*)");
		System.out.println("#1 result = " + result);

		if (hasNotCustomDeliminator(input)) {
			return input.split("[,;]");
		}

		Matcher matcher = Pattern.compile(REGULAR_EXPRESSION).matcher(input);
		if (matcher.find()) {
			String customDeliminator = matcher.group(1);
			String numbers = matcher.group(2);
			return numbers.split(customDeliminator);
		}

		return null;
	}

	private static boolean hasNotCustomDeliminator(String input) {
		return !Pattern.compile(REGULAR_EXPRESSION).matcher(input).find();
	}
}
