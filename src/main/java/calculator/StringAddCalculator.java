package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

	static public int SplitAndSum(String givenString) {
		if (checkNullOrEmpty(givenString)) {
			return 0;
		}
		String[] splitString = split(givenString);
		List<Integer> intValues = stringToInt(splitString);

		intValues.forEach(StringAddCalculator::checkNegativeInteger);
		return intValues.stream().mapToInt(intValue -> intValue).sum();
	}

	static private boolean checkNullOrEmpty(String givenString) {
		return givenString == null || givenString.isEmpty();
	}

	static private String[] split(String givenString) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(givenString);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}
		return givenString.split("[,:]");
	}

	static private List<Integer> stringToInt(String[] values) {
		return Arrays.stream(values)
			.map(StringAddCalculator::intValueOf)
			.collect(Collectors.toList());

	}

	static private int intValueOf(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new RuntimeException("숫자값을 입력해주세요");
		}
	}

	static private void checkNegativeInteger(int value) {
		if (value < 0) {
			throw new RuntimeException("음수는 입력할 수 없습니다.");
		}
	}
}
