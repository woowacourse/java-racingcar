package stringcalculator;

public class StringCalculator {
	public static int splitAndSum(String input) {
		if (input == null || input.isBlank()) {
			return 0;
		}
		String[] numbers = input.split(",");
		int sum = 0;
		for(String number: numbers) {
			sum += Integer.parseInt(number);
		}
		return sum;
	}
}