package calculator;

public class Calculator {
	public static int splitAndSum(final String text) {
		if (text == null || text.isEmpty()) {
			return 0;
		}
		final String[] splitValues = split(text);
		return sum(splitValues);
	}

	private static String[] split(String text) {
		String basicDelimiter = ",|:";
		if (text.startsWith("//")) {
			String[] splitValues = text.split("\n");
			String delimiter = splitValues[0].substring(2);
			String customText = splitValues[1];
			return customText.split(String.format("%s|%s", basicDelimiter, delimiter));
		}
		return text.split(basicDelimiter);
	}

	private static int sum(String[] values) {
		int sum = 0;
		for (String i : values) {
			sum += Integer.parseInt(i);
		}
		return sum;
	}
}
