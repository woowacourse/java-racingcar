package calculator;

public class StringCalculator {
	public static int splitAndSum(String a) {
		if (checkNull(a)) {
			return 0;
		}

		return sum(splitByColon(a));
	}

	private static boolean checkNull(String a) {
		return a == null || a.isEmpty();
	}

	private static String[] splitByColon(String a) {
		return a.split(":");
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

}
