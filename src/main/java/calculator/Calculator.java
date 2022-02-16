package calculator;

public class Calculator {
	public static int splitAndSum(final String text) {
		if (text == null || text.isEmpty()) {
			return 0;
		}
		final String[] splitValues = text.split(",|:");
		return sum(splitValues);
	}

	private static int sum(String[] values) {
		int sum = 0;
		for (String i : values) {
			sum += Integer.parseInt(i);
		}
		return sum;
	}
}
