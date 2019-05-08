package cal;

public class Calculator {
	private int value;

	public int execute(String expression) {
		String[] parsedExpression = splitExpression(expression);

		value = parseInt(parsedExpression[0]);
		for (int i = 1; i < parsedExpression.length; i+=2) {
			int number = parseInt(parsedExpression[i]);
			String operator = parsedExpression[i+1];
		}

		return value;
	}

	private int parseInt(String str) {
		return Integer.parseInt(str);
	}

	private String[] splitExpression(String expression) {
		return expression.split(" ");
	}

	
}
