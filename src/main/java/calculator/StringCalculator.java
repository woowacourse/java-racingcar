package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public int calculate(String input) {
		if (isNullOrEmpty(input)) {
			return 0;
		}
		return sum(toInts(split(input)));
	}

	private boolean isNullOrEmpty(String input) {
		return input == null || input.isEmpty();
	}

	private String[] split(String input) {
		return getText(input).split(getDelimiter(input));
	}

	private String getText(String input) {
		Matcher m = getMatcher(input);
		if (m.find()) {
			return m.group(2);
		}
		return input;
	}

	private String getDelimiter(String input) {
		Matcher m = getMatcher(input);
		if (m.find()) {
			return m.group(1);
		}
		return ",|:";
	}

	private Matcher getMatcher(String input) {
		return Pattern.compile("//(.)\n(.*)").matcher(input);
	}

	private int[] toInts(String[] inputTokens) {
		int[] numberList = new int[inputTokens.length];
		for (int i = 0; i < inputTokens.length; i++) {
			numberList[i] = Integer.parseInt(inputTokens[i]);
		}
		return numberList;
	}

	private int sum(int[] numbers) {
		int total = 0;
		for (int number : numbers) {
			total += number;
		}
		return total;
	}
}
