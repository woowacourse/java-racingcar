package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public int SplitAndSum(String givenString) {
        if (checkNullOrEmpty(givenString)) {
            return 0;
        }
        String[] splitString = split(givenString);
		int[] intValues = stringToInt(splitString);
		Arrays.stream(intValues).forEach(this::checkNegativeInteger);
        return Arrays.stream(intValues).sum();
    }


    private boolean checkNullOrEmpty(String givenString) {
        return givenString == null || givenString.isEmpty();
    }

    private String[] split(String givenString) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(givenString);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return givenString.split("[,:]");
    }

	private int[] stringToInt(String[] values) {
		int[] intValues = new int[values.length];
		for (int i = 0; i < values.length; i++) {
			intValues[i] = intValueOf(values[i]);
		}
		return intValues;
	}

	private int intValueOf(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new RuntimeException("숫자값을 입력해주세요");
		}
	}

	private void checkNegativeInteger(int value) {
		if (value < 0) {
			throw new RuntimeException("음수는 입력할 수 없습니다.");
		}
	}
}
