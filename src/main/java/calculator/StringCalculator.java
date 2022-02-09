package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
	public static int splitAndSum(String text) {
		if (text == null || text.equals("")) {
			return 0;
		}
		List<Integer> numbers = toInt(splitText(text));
		if (numbers.stream().anyMatch(number -> number < 0)) {
			throw new RuntimeException();
		}
		return numbers.stream().mapToInt(number -> number).sum();
	}

	public static List<String> splitText(String text) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		String customDelimiter = "";
		if (m.find()) {
			customDelimiter = "|" + m.group(1);
			text = m.group(2);
		}
		return Arrays.asList(text.split(",|:" + customDelimiter));
	}

	public static List<Integer> toInt(List<String> list) {
		return list.stream()
			.map(numberStr -> Integer.parseInt(numberStr))
			.collect(Collectors.toList());
	}
}
