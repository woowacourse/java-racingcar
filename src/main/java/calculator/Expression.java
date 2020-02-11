package calculator;

public class Expression {
	private static final String COLON_DELIMITER = ":";
	private static final String COMMA_DELIMITER = ",";
	public static final int END_OF_CUSTOM_DELIMITER = 4;

	public static String getFinalExpression(String value) {
		String expression = generateExpression(value);

		validate(expression);

		return expression;
	}

	private static String generateExpression(String value) {
		String delimiter = Delimiter.getDelimiter(value);

		if (COLON_DELIMITER.equals(delimiter)) {
			return value.replace(COMMA_DELIMITER, COLON_DELIMITER);
		}
		return value.substring(END_OF_CUSTOM_DELIMITER)
				.replace(delimiter, COLON_DELIMITER)
				.replace(COMMA_DELIMITER, COLON_DELIMITER);
	}

	public static void validate(String expression) {
		if (!expression.matches("^[0-9]+(:[0-9]+)*")) {
			throw new RuntimeException();
		}
	}
}
