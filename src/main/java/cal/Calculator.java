package cal;

public class Calculator {
	private int value;

	public int execute(String expression) {
		String[] splitedExpression = splitExpression(expression);

		for (int i = 1; i < splitedExpression.length; i+=2) {

		}
	}

	private String[] splitExpression(String expression) {
		return expression.split(" ");
	}
}
