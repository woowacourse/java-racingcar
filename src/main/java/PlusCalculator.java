public class PlusCalculator {
	private static final String DELIMITER = "[,:]";

	public static int calculate(final String value) {
		final String[] values = splitValues(value);
		int sum = 0;
		for (final String token : values) {
			sum += Integer.parseInt(token);
		}
		return sum;
	}

	private static String[] splitValues(final String value) {
		return value.split(DELIMITER);
	}
}
