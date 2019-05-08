package cal;

public class Calculator {
	private static String PLUS = "+";
	private static String MINUS = "-";
	private static String MULTIPLY = "*";
	private static String DEVIDE = "/";
	private int value;

	public int execute(String expression) {
		String[] parsedExpression = splitExpression(expression);

		value = parseInt(parsedExpression[0]);
		for (int i = 1; i < parsedExpression.length; i += 2) {
			String operator = parsedExpression[i];
			int number = parseInt(parsedExpression[i + 1]);

		}

		return value;
	}

	private int parseInt(String str) {
		return Integer.parseInt(str);
	}

	private String[] splitExpression(String expression) {
		return expression.split(" ");
	}

	private void calculate(String operator, int number) {
		if (operator.equals(PLUS)) {
			add(number);
		}

		if (operator.equals(MINUS)) {
			minus(number);
		}

		if (operator.equals(MULTIPLY)) {
			multiply(number);
		}

		if (operator.equals(DEVIDE)) {
			devide(number);
		}
	}

	private void add(int number) {
		value += number;
	}

	private void minus(int number) {
		value -= number;
	}

	private void multiply(int number) {
		value *= number;
	}

	private void devide(int number) {
		value /= number;
	}
}
