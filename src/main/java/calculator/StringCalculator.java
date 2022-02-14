package calculator;

import static calculator.Message.*;
import static calculator.Constants.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public static void main(String[] args) {
		calculator();
	}

	public static void calculator() {
		System.out.println(add(userInput()));
	}

	public static String userInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public static int add(String input) {
		if (isNullOREmpty(input)) {
			return NULL_OR_EMPTY;
		}
		Matcher matcher = Pattern.compile(REGEX).matcher(input);
		if (matcher.find()) {
			return splitByCustomDivider(matcher);
		}
		return splitByDivider(input);
	}

	public static int splitByCustomDivider(Matcher matcher) {
		String customDivider = matcher.group(1);
		String[] numbers = matcher.group(2).split(customDivider + OR + ORIGINAL_DIVIDER);
		return sum(numbers);
	}

	public static int sum(String[] numbers) {
		int result = 0;
		for (String number : numbers) {
			checkNonNumber(number);
			checkNegativeNumber(number);
			result += Integer.parseInt(number);
		}
		return result;
	}

	public static void checkNonNumber(String number) {
		try {
			Integer.parseInt(number);
		} catch (Exception e) {
			throw new RuntimeException(NON_DIGITS_ERROR_MESSAGE);
		}
	}

	public static void checkNegativeNumber(String number) {
		if (Integer.parseInt(number) < 0) {
			throw new RuntimeException(NEGATIVE_NUMBER_ERROR_MESSAGE);
		}
	}

	public static boolean isNullOREmpty(String input) {
		return input == null || input.equals("");
	}

	private static int splitByDivider(String input) {
		String[] numbers = input.split(ORIGINAL_DIVIDER);
		return sum(numbers);
	}

}
