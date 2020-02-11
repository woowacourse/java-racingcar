package calculator;

/**
 *
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @since 2020/02/11
 */
public class Calculator {
	public static final String DELIMETER = ",";
	public static final String CUSTOM_DELIMETER_PREFIX = "//";
	public static final String CUSTOM_DELIMETER_POSTFIX = "\n";

	public static int calculate(String input) {
		String delimeter = DELIMETER;
		String[] splitInput = input.split(delimeter);
		if (input.contains(CUSTOM_DELIMETER_POSTFIX)&&input.contains(CUSTOM_DELIMETER_PREFIX)){
			String[] splitDelimiter = input.split(CUSTOM_DELIMETER_POSTFIX);
			delimeter = String.valueOf(splitDelimiter[0].charAt(splitDelimiter[0].length() - 1));
			splitInput = splitDelimiter[1].split(delimeter);
		}
		int result = 0;
		for (String operand: splitInput) {
			result += Integer.parseInt(operand);
		}
		return result;
	}
}
