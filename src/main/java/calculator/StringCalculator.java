package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public int calculate(String text) {
		if (text == null || text.isEmpty()) {
			return 0;
		}
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (m.find()) {
			String customDelimiter = m.group(1);
			String[] tokens= m.group(2).split(customDelimiter);
			return sum(toInts(tokens));
		}
		return sum(toInts(text.split(",|:")));
	}

	private int[] toInts(String[] values) {
		int[] numberList = new int[values.length];
		for (int i = 0; i < values.length; i++) {
			numberList[i] = Integer.parseInt(values[i]);
		}
		return numberList;
	}

	private int sum(int[] values) {
		int total = 0;
		for (int value : values) {
			total += value;
		}
		return total;
	}
}
