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
			calculate(operator, number);
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
			subtract(number);
		}

		if (operator.equals(MULTIPLY)) {
			multiply(number);
		}

		if (operator.equals(DEVIDE)) {
			devide(number);
		}
	}

	private void add(int number) {
		value = Math.addExact(value, number);
	}

	private void subtract(int number) {
		value = Math.subtractExact(value, number);
	}

	private void multiply(int number) {
		value = Math.multiplyExact(value, number);
	}

	private void devide(int number) {
		value /= number;
	}
}
