package calculator;

public class Calculator {

	public static final String CUSTOM_PREFIX = "//";
	public static final String BASIC_DELIMITER = ",|:";
	public static final String CUSTOM_DELIMITER = "\n";
	public static final int CUSTOM_INDEX = 0;
	public static final int CUSTOM_DELIMITER_INDEX = 2;
	public static final int CUSTOM_TEXT_INDEX = 1;
	public static final String FORMAT = "%s|%s";

	public static int splitAndSum(final String text) {
		if (text == null || text.isEmpty()) {
			return 0;
		}
		final String[] splitValues = split(text);
		return sum(splitValues);
	}

	private static String[] split(String text) {
		String basicDelimiter = BASIC_DELIMITER;
		if (isCustom(text)) {
			String[] splitValues = text.split(CUSTOM_DELIMITER);
			String delimiter = splitValues[CUSTOM_INDEX].substring(CUSTOM_DELIMITER_INDEX);
			String customText = splitValues[CUSTOM_TEXT_INDEX];
			return customText.split(String.format(FORMAT, basicDelimiter, delimiter));
		}
		return text.split(basicDelimiter);
	}

	private static boolean isCustom(String text) {
		return text.startsWith(CUSTOM_PREFIX);
	}

	private static int sum(String[] values) {
		int sum = 0;
		for (String i : values) {
			int target = Integer.parseInt(i);
			checkNegativeNumber(target);
			sum += target;
		}
		return sum;
	}

	private static void checkNegativeNumber(int number) {
		if (number < 0) {
			throw new RuntimeException("양수를 입력해주세요.");
		}
	}
}
