package calculator;

public class StringCalculator {
	public static int add(String input) {
		String[] numbers = input.split(",|:");
		int result = 0;
		for(String number: numbers) {
			result += Integer.parseInt(number);
		}
		return result;
	}
}
