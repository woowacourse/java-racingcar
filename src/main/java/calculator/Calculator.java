package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static final String CUSTOM_REGEX_PATTERN = "//(.*)\n(.*)";
	public static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_REGEX_PATTERN);
	private String delimiter = ",:";

	public int splitAndSumNumber(String userInputText) {
		if (isEmptyOrNull(userInputText)) {
			return 0;
		}
		return sum(split(userInputText));
	}

	private boolean isEmptyOrNull(String userInputText) {
		return userInputText == null || userInputText.isEmpty();
	}

	private String[] split(String userInputText) {
		Matcher customMatcher = CUSTOM_PATTERN.matcher(userInputText);
		if (customMatcher.find()) {
			String customDelimiter = customMatcher.group(1);
			userInputText = customMatcher.group(2);
			addCustomDelimiter(customDelimiter);
		}
		return userInputText.split(createNewDelimiter());
	}

	private void addCustomDelimiter(String customDelimiter) {
		delimiter += customDelimiter;
	}

	private String createNewDelimiter() {
		return String.join("|", delimiter.split(""));
	}

	private int sum(String[] values) {
		int total = 0;
		for (String value : values) {
			total += toInt(value);
		}
		return total;
	}

	private int toInt(String stringValue) {
		int value = parseIntFromString(stringValue);
		if (value < 0) {
			throw new RuntimeException("음수를 입력하셨습니다.");
		}
		return value;
	}

	private int parseIntFromString(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException exception) {
			throw new RuntimeException("숫자 이외의 값을 입력하셨습니다.");
		}
	}

}
