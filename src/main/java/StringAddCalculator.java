public class StringAddCalculator {
	public static int calculate(final String value) {
		String[] values;
		int result = 0;

		if (value == null || value.isEmpty()) {
			return 0;
		}

		values = value.split("[:,]");
		for (String number : values) {
			result += Integer.parseInt(number);
		}
		return result;
	}
}
