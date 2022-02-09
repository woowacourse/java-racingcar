package calculator;

public class StringCalculator {

	public int calculate(String text) {
		if (text == null || text.isEmpty()) {
			return 0;
		}
		return sum(toInts(text.split(",")));
	}

	private int[] toInts(String[] values) {
		int[] numberList = new int[values.length];
		for (int i = 0; i < values.length; i++) {
			numberList[i] = Integer.parseInt(values[i]);
		}
		return numberList;
	}

	private int sum(int[] values) {
		int total = 0;
		for (int value : values) {
			total += value;
		}
		return total;
	}
}
