package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	public static int splitAndSum(String a) {
		if (checkNull(a)) {
			return 0;
		}

		isNegative(splitByColon(a));
		return checkCustomSplit(a);

	}

	private static boolean checkNull(String a) {
		return a == null || a.isEmpty();
	}

	private static String[] splitByColon(String a) {
		return a.replace(",", ":").split(":");
	}

	private static void isNegative(String[] a) {
		if (Arrays.stream(a).filter(b -> b.contains("-")).count() > 0) {
			throw new RuntimeException();
		}
	}

	private static int sum(String[] numbers) {
		if (numbers.length == 0) {
			return 0;
		}
		int result = 0;
		for (String str : numbers) {
			result += Integer.parseInt(str);
		}
		return result;
	}

	private static int checkCustomSplit(String a) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(a);
		if (m.find()) {
			String customDelimiter = m.group(1);
			String[] tokens = m.group(2).split(customDelimiter);
			return sum(tokens);
		}
		return sum(splitByColon(a));
	}

}
