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

	private static int getSum(String input) {
		return Arrays.stream(convertStringArrToIntArr(checkAndSplit(input)))
			.sum();
	}

	private static int[] convertStringArrToIntArr(String[] arr) {
		return Arrays.stream(arr)
			.mapToInt(StringCalculator::convertStringToNaturalNumber)
			.toArray();
	}

	private static int convertStringToNaturalNumber(String string) {
		int converted = Integer.parseInt(string);
		if (converted < 0) {
			throw new RuntimeException();
		}
		return converted;
	}

	private static String[] checkAndSplit(String input) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
		if (m.find()) {
			String delimiter = "[" + m.group(1) + ",:]";
			return m.group(2).split(delimiter);
		}
		return input.split("[,:]");
	}
}