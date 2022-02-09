package calculator;

import java.util.Arrays;
import java.util.List;
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
		return Arrays.asList(text.split(","));
	}

	public static List<Integer> toInt(List<String> list) {
		return list.stream()
			.map(a -> Integer.parseInt(a))
			.collect(Collectors.toList());
	}
}