package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	public static int splitAndSum(String input) {
		if (isEmpty(input)) {
			return 0;
		}
		return getSum(input);
	}

	private static boolean isEmpty(String input) {
		return input == null || input.isBlank();
	}

	private static int[] convertStringArrToIntArr(String[] arr) {
		return Arrays.stream(arr)
			.mapToInt(StringCalculator::convertStringToInt)
			.toArray();
	}

	private static int convertStringToInt(String string) {
		int converted = Integer.parseInt(string);
		if (converted < 0) {
			throw new RuntimeException();
		}
		return converted;
	}

	private static int getSum(String input) {
		return Arrays.stream(convertStringArrToIntArr(checkAndSplit(input)))
			.sum();
	}

	private static String[] split(String input, String delimiter) {
		return input.split(delimiter);
	}

	private static String[] checkAndSplit(String input) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
		if (m.find()) {
			String delimiter = "[" + m.group(1) + ",:]";
			return split(m.group(2), delimiter);
		}
		return split(input, "[,:]");
	}
}