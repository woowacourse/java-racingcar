package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	private static final String CUSTOM_REGEX_PATTERN = "//(.*)\n(.*)";
	private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_REGEX_PATTERN);
	private static final String DEFAULT_DELIMITER = ",|:";

	public int splitAndSumNumber(String userInputText) {
		if (isEmptyOrNull(userInputText)) {
			return 0;
		}
		String[] numbers = split(userInputText);
		validateNumbers(numbers);
		return sum(numbers);
	}

	private boolean isEmptyOrNull(String userInputText) {
		return userInputText == null || userInputText.isEmpty();
	}

	private String[] split(String userInputText) {
		Matcher customMatcher = CUSTOM_PATTERN.matcher(userInputText);
		if (customMatcher.find()) {
			return customSplit(customMatcher);
		}
		return userInputText.split(DEFAULT_DELIMITER);
	}

	private String[] customSplit(Matcher customMatcher) {
		String customDelimiter = customMatcher.group(1);
		return customMatcher.group(2).split(customDelimiter);
	}

	private int sum(String[] numbers) {
		int total = 0;
		for (String number : numbers) {
			total += Integer.parseInt(number);
		}
		return total;
	}

	private void validateNumbers(String[] numbers) {
		checkIsNotDigit(numbers);
		checkIsNegativeNumber(numbers);
	}

	private void checkIsNotDigit(String[] numbers) {
		if (Arrays.stream(numbers).anyMatch(number -> !Character.isDigit(number.charAt(0)))) {
			throw new RuntimeException("숫자 이외의 값을 입력하셨습니다.");
		}
	}

	private void checkIsNegativeNumber(String[] numbers) {
		if (Arrays.stream(numbers).anyMatch(number -> Integer.parseInt(number) < 0)) {
			throw new RuntimeException("음수를 입력하셨습니다.");
		}
	}
}
