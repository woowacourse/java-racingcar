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
		if (isBlank(text))
			return 0;
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

	private static int sum(String[] values) {
		int sum = 0;
		for (String i : values) {
			int target = convertValue(i);
			checkNegativeNumber(target);
			sum += target;
		}
		return sum;
	}

	private static boolean isCustom(String text) {
		return text.startsWith(CUSTOM_PREFIX);
	}

	private static boolean isBlank(String text) {
		return text == null || text.isEmpty();
	}

	private static int convertValue(String string) {
		if (isBlank(string)) {
			return 0;
		}
		if (!isNumber(string)) {
			throw new IllegalArgumentException("숫자를 입력해주세요.");
		}
		return Integer.parseInt(string);
	}

	private static boolean isNumber(String string) {
		return string.matches("[+-]?\\d*(\\.\\d+)?");
	}

	private static void checkNegativeNumber(int number) {
		if (number < 0) {
			throw new RuntimeException("양수를 입력해주세요.");
		}
	}
}
