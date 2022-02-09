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
		int[] numberArray = new int[inputTokens.length];
		for (int i = 0; i < inputTokens.length; i++) {
			numberArray[i] = parseInt(inputTokens[i]);
		}
		return numberArray;
	}

	private int parseInt(String inputToken) {
		int value = Integer.parseInt(inputToken);
		if (value < 0) {
			throw new IllegalArgumentException("숫자는 양수 또는 0이여야 합니다.");
		}
		return value;
	}

	private int sum(int[] numbers) {
		int total = 0;
		for (int number : numbers) {
			total += number;
		}
		return total;
	}
}
