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
		List<String> numberStringList = split(input);
		checkRightPositiveInteger(numberStringList);
		List<Integer> numberList = toNumberList(numberStringList);
		return numberList.stream().mapToInt(num -> num).sum();
	}

	private static List<Integer> toNumberList(List<String> numberStringList) {
		return numberStringList.stream()
			.mapToInt(Integer::parseInt)
			.boxed()
			.collect(Collectors.toList());
	}

	private static void checkRightPositiveInteger(List<String> numberStringList) {
		numberStringList.forEach(StringCalculator::checkNumberStringException);
	}

	private static void checkNumberStringException(String numberString){
		if (!isPositiveInteger(numberString)) {
			throw new RuntimeException("양의 정수를 입력 해주세요.");
		}
	}

	private static boolean isNullOrEmpty(String input) {
		return input == null || input.isBlank();
	}

	private static boolean isPositiveInteger(String input) {
		return input.matches("^(0|[1-9][0-9]*)$");
	}

	private static List<String> split(String input) {
		List<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));
		String parameterString = getParameterString(input, delimiters);
		String delimiter = String.join("|", delimiters);
		return Arrays.asList(parameterString.split(delimiter));
	}

	private static String getParameterString(String input, List<String> delimiters) {
		if(input.contains("//") && input.contains("\n")){
			String customDelimiter = input.substring(input.indexOf("//") + 2, input.indexOf("\n"));
			delimiters.add(customDelimiter);
			return input.substring(input.indexOf("\n") + 1);
		}
		return input;
	}
}
