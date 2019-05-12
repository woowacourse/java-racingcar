package calculator.domain;

public class Calculator {
	private String[] values;

	public Calculator(String[] values) {
		this.values = values;
	}

	public double calculate() {
		double result = Double.parseDouble(values[0]);

		for (int i = 1; i < values.length - 1; i += 2) {
			result = operate(result, Double.parseDouble(values[i + 1]), Operator.of(values[i]));
		}
		return result;
	}

	private double operate(double num1, double num2, Operator operator) {
		switch (operator) {
			case ADDITION:
				return num1 + num2;
			case SUBTRACTION:
				return num1 - num2;
			case MULTIPLICATION:
				return num1 * num2;
			case DIVISION:
				return num1 / num2;
			default:
				throw new IllegalArgumentException("올바르지 않은 계산식입니다.");
		}
	}
}
