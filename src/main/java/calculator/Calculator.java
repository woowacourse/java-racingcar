package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	private String delimiter = ",:";

	public int splitAndSumNumber(String inputValue) {
		if (isEmptyValue(inputValue)) {
			return 0;
		}
		return sum(split(inputValue));
	}

	private boolean isEmptyValue(String inputValue) {
		return inputValue == null || inputValue.isEmpty();
	}

	private String[] split(String inputValue) {
		Matcher matcher = Pattern.compile("//(.*)\n(.*)").matcher(inputValue);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			inputValue = matcher.group(2);
			delimiter += customDelimiter;
		}
		String newDelimiter = createNewDelimiter();
		return inputValue.split(newDelimiter);
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
