package calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	public int splitAndSum(String text) {
		if (!isValidValues(text)) {
			return 0;
		}
		int[] numbers = stringToIntArray(getValues(text));

		return add(numbers);
	}

	private boolean isValidValues(String text) {
		return text != null && !text.trim().isEmpty();
	}

	private int[] stringToIntArray(String[] strings) {
		ArrayList<Integer> numbers = new ArrayList<>();
		for (String i : strings) {
			numbers.add(convertValue(i));
		}
		return numbers.stream().mapToInt(Integer::intValue).toArray();
	}

	private int convertValue(String string) {
		if (!isValidValues(string)) {
			return 0;
		}
		if (!isNumber(string)) {
			throw new IllegalArgumentException("숫자를 입력해주세요.");
		}
		return Integer.parseInt(string);
	}

	private boolean isNumber(String string) {
		return string.matches("[+-]?\\d*(\\.\\d+)?");
	}

	private String[] getValues(String text) {
		String delimiter = ",|:";
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (m.find()) {
			return m.group(2).split(String.format("%s|%s", delimiter, m.group(1)));
		}
		return text.split(delimiter);
	}

	private int add(int[] numbers) {
		if (numbers.length == 1) {
			return numbers[0];
		}
		int result = 0;
		for (int i : numbers) {
			result += i;
		}
		return result;
	}
}
