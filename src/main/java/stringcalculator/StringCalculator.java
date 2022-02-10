package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	public StringCalculator() {
	}

	public String[] split(String input) {
		return input.split(",|:");
	}

	public String[] customDelimiter(String input) {
		Matcher m = getMatcher(input);
		if (!m.find()) {
			throw new RuntimeException();
		}
		String customDelimiter = m.group(1);
		if (isSpecialDelimiter(customDelimiter)) {
			return m.group(2).split(addCustomDelimiterPrefix(customDelimiter));
		}
		return m.group(2).split(customDelimiter);
	}

	private Matcher getMatcher(String input) {
		return Pattern.compile("//(.)\n(.*)").matcher(input);
	}

	private String addCustomDelimiterPrefix(String customDelimiter) {
		return "\\" + customDelimiter;
	}

	private boolean isSpecialDelimiter(String customDelimiter) {
		return customDelimiter.equals("+") || customDelimiter.equals("*") || customDelimiter.equals("^");
	}

	public int splitAndSum(String input) {
		if (validNullOrEmpty(input)) {
			return 0;
		}

		if (isCustomInput(input)) {
			String[] numbers = customDelimiter(input);
			return this.sum(numbers);
		}
		String[] numbers = split(input);
		return this.sum(numbers);
	}

	private boolean isCustomInput(String input) {
		return input.length() > 2 && input.startsWith("//");
	}

	private boolean validNullOrEmpty(String input) {
		return input == null || input.equals("");
	}

	public int sum(String[] numbers) {
		return Arrays.stream(numbers).mapToInt(this::mapToInt).sum();
	}

	private int mapToInt(String number) {
		try {
			int i = Integer.parseInt(number);
			if (i < 0) {
				throw new RuntimeException("음수의 값이 입력되었습니다. 양수를 입력하세요.");
			}
			return i;
		} catch (NumberFormatException e) {
			throw new RuntimeException("숫자 이외의 값이 입력되었습니다. 숫자를 입력하세요.");
		}
	}
}
