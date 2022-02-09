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
		String[] numbers = input.split("[,:]");
		int sum = 0;
		for (String number : numbers) {
			sum += Integer.parseInt(number);
		}
		return sum;
	}
}