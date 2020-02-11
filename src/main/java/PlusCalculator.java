public class PlusCalculator {
	private static final String COMMA = ",";
	private static final String COLON = ":";

	public static int calculate(final String value) {
		final String[] values = splitValues(value);
		int sum = 0;
		for (final String token : values) {
			sum += Integer.parseInt(token);
		}
		return sum;
	}

	private static String[] splitValues(final String value) {
		if (value.contains(COMMA)) {
			return value.split(COMMA);
		}
		return value.split(COLON);
	}
}
