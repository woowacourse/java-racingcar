package calculator;

public class Calculator {
	public int splitAndSum(String text) {
		if (!isValidValues(text)) {
			return 0;
		}
		String[] numbers = text.split(",|:");

		return add(numbers);
	}

	private boolean isValidValues(String text) {
		return text != null && !text.trim().isEmpty();
	}

	private int add(String[] numbers) {
		if (numbers.length == 1) {
			return Integer.parseInt(numbers[0]);
		}
		return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
	}
}
