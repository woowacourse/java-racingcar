package stringcalculator;

public class StringCalculator {
	public static int splitAndSum(String input) {
		if (isEmpty(input)) {
			return 0;
		}
		return getSum(input);
	}

	private static boolean isEmpty(String input) {
		return input == null || input.isBlank();
	}

	private static int getSum(String input) {
		int sum = 0;
		for (String number : split(input)) {
			sum += Integer.parseInt(number);
		}
		return sum;
	}

	private static String[] split(String input) {
		return input.split("[,:]");
	}
}