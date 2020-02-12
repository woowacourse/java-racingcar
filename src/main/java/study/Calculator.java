package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Calculator {
	public static int calculate(String input) {
		String regex = checkCustomRegex("", input);

		input = subStringInput(regex, input);

		return Stream.of(splitAsRegex(regex, input))
			.filter(Calculator::isNumber)
			.map(Integer::parseInt)
			.filter(Calculator::isPositive)
			.reduce(Integer::sum)
			.orElse(0);
	}

	private static String checkCustomRegex(String regex, String input) {
		Pattern p = Pattern.compile("//(.)\n");
		Matcher matcher = p.matcher(input);
		while (matcher.find()) {
			regex = matcher.group(1);
		}

		return regex;
	}

	private static String subStringInput(String regex, String input) {
		if (!regex.equals("")) {
			return input.substring(4);
		}

		return input;
	}

	private static String[] splitAsRegex(String regex, String input) {
		return input.split("[" + regex + ",:]");
	}


	private static boolean isNumber(String input) {
		if (input.chars().mapToObj(number -> (char)number).noneMatch(Character::isDigit)) {
			throw new RuntimeException("잘못 입력하셨습니다.");
		}

		return true;
	}
	private static boolean isPositive(int number) {
		if (number < 0) {
			throw new RuntimeException("잘못 입력하셨습니다.");
		}

		return true;
	}

}
