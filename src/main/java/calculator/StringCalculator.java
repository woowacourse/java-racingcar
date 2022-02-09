package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

	public static int calculate(String input) {
		if (isNullOrEmpty(input)) {
			return 0;
		}
		if(isPositiveInteger(input)){
			return Integer.parseInt(input);
		}
		List<String> numberStringList = split(input);
		// 문자나 음수 걸러내기
		checkRightPositiveInteger(numberStringList);
		List<Integer> numberArray = numberStringList.stream()
			.mapToInt(Integer::parseInt)
			.boxed()
			.collect(Collectors.toList());

	}

	private static void checkRightPositiveInteger(List<String> numberStringList) {
		numberStringList.forEach(numberString -> {
			if (isPositiveInteger(numberString)) {
				throw new RuntimeException("양의 정수를 입력 해주세요.");
			}
		});
	}

	private static boolean isNullOrEmpty(String input) {
		return input.isBlank() || input == null;
	}

	private static boolean isPositiveInteger(String input) {
		return input.matches("^(0|[1-9][0-9]*)$");
	}

	private static List<String> split(String input) {
		List<String> delimiters = new ArrayList<>();
		delimiters.add(",");
		delimiters.add(":");

		if(input.contains("//") && input.contains("\n")){
			String customDelimiter = input.substring(input.indexOf("//") + 2, input.indexOf("\n"));
			delimiters.add(customDelimiter);
			input = input.substring(input.indexOf("\n") + 1);
		}
		String delimiter = String.join("|", delimiters);
		return Arrays.asList(input.split(delimiter));
	}
}
