package calculator;

public class Calculator {
	public int splitAndSum(String text) {
		if (!isValidValues(text)) {
			return 0;
		}
		String[] numbers = text.split(",");

		return add(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
	}

	private boolean isValidValues(String text) {
		return text != null && !text.trim().isEmpty();
	}

	private int add(int i, int j) {
		return i + j;
	}
}
