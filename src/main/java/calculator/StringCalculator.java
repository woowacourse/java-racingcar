package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import calculator.utils.validator.StringNumberValidator;

public class StringCalculator {

	private static final String CUSTOM_SEPARATOR_START_SIGNATURE = "//";
	private static final String CUSTOM_SEPARATOR_END_SIGNATURE = "\n";
	private static final String JOINING_SEPARATOR_DELIMITER = "|";
	private static final String BASIC_SEPARATOR_COMMA = ",";
	private static final String BASIC_SEPARATOR_COLON = ":";

	public static int calculate(List<String> stringNumbers) {
		checkRightPositiveInteger(stringNumbers);
		List<Integer> numberList = toNumberList(stringNumbers);
		return numberList.stream().mapToInt(num -> num).sum();
	}

	private static void checkRightPositiveInteger(List<String> numberStringList) {
		numberStringList.forEach(StringNumberValidator::validate);
	}

	private static List<Integer> toNumberList(List<String> numberStringList) {
		return numberStringList.stream()
			.map(Integer::valueOf)
			.collect(Collectors.toList());
	}

	private static List<String> split(String input) {
		List<String> delimiters = new ArrayList<>(Arrays.asList(BASIC_SEPARATOR_COMMA, BASIC_SEPARATOR_COLON));
		String parameterString = getParameterString(input, delimiters);
		String delimiter = String.join(JOINING_SEPARATOR_DELIMITER, delimiters);
		return Arrays.asList(parameterString.split(delimiter));
	}

	private static String getParameterString(String input, List<String> delimiters) {
		if (hasCustomSeparator(input)) {
			String customDelimiter = input.substring(input.indexOf(CUSTOM_SEPARATOR_START_SIGNATURE) + 2, input.indexOf(CUSTOM_SEPARATOR_END_SIGNATURE));
			delimiters.add(customDelimiter);
			return input.substring(input.indexOf(CUSTOM_SEPARATOR_END_SIGNATURE) + 1);
		}
		return input;
	}

	private static boolean hasCustomSeparator(String input) {
		return input.contains(CUSTOM_SEPARATOR_START_SIGNATURE) && input.contains(CUSTOM_SEPARATOR_END_SIGNATURE);
	}
}
