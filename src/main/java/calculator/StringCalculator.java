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
		return numbers.stream().mapToInt(i -> i).sum();
	}

	public static List<String> splitText(String text) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		String customDelimiter = "";
		String str = text;
		if (m.find()) {
			customDelimiter = "|" + m.group(1);
			str = m.group(2);
		}
		return Arrays.asList(str.split(",|:" + customDelimiter));
	}

	public static List<Integer> toInt(List<String> list) {
		return list.stream()
			.map(a -> Integer.parseInt(a))
			.collect(Collectors.toList());
	}
}