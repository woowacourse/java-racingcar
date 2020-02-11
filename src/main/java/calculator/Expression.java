package calculator;

public class Expression {
	private static final String COLON_DELIMITER = ":";
	private static final String COMMA_DELIMITER = ",";

	public static String getFinalExpression(String value) {
		String delimiter = Delimiter.getDelimiter(value);

		if (COLON_DELIMITER.equals(delimiter)) {
			return value.replace(COMMA_DELIMITER, COLON_DELIMITER);
		}
		return value.substring(4)
				.replace(delimiter, COLON_DELIMITER)
				.replace(COMMA_DELIMITER, COLON_DELIMITER);
	}
}
