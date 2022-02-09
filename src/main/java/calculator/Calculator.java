package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	private String separators = ",:";

	public int splitAndSumNumber(String inputValue) {
		if (inputValue == null || inputValue.isEmpty()) {
			return 0;
		}

		String[] splitValues = customSplit(inputValue);

		return sumNumber(splitValues);
	}

	private String[] customSplit(String inputValue) {
		Matcher matcher = Pattern.compile("//(.*)\n(.*)").matcher(inputValue);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			inputValue = matcher.group(2);
			separators += customDelimiter;
		}
		String newSeparators = String.join("|", separators.split(""));
		return inputValue.split(newSeparators);
	}

	private int sumNumber(String[] splitValues) {
		int totalValue = 0;
		for (String stringValue : splitValues) {
			totalValue += toInt(stringValue);
		}
		return totalValue;
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
