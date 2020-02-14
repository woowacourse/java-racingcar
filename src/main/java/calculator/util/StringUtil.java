package calculator.util;

public class StringUtil {
	public static final String COMMA = ",";
	public static final String COLON = ":";
	public static final int DELIMITER_INDEX = 2;
	public static final int NO_INDEX = -1;

	public static String[] parseString(String expression) {
		if (isUsingCustomDelimiter(expression)) {
			int endOfCustomDelimiter = expression.indexOf("\n");
			validateProperInput(endOfCustomDelimiter);
			String customDelimiter = expression.substring(DELIMITER_INDEX, endOfCustomDelimiter);
			expression = expression.replaceAll(customDelimiter, COMMA);
			return expression.substring(endOfCustomDelimiter + 1).split(COMMA);
		}
		return expression.replaceAll(COLON, COMMA).split(COMMA);
	}

	private static void validateProperInput(int end) {
		if (end == NO_INDEX) {
			throw new IllegalArgumentException("입력이 잘못 되었습니다.");
		}
	}

	private static boolean isUsingCustomDelimiter(String expression) {
		return expression.startsWith("//");
	}

	public static boolean isNullOrBlank(String value) {
		return value == null || value.trim().isEmpty();
	}
}
