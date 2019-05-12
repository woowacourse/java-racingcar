package calculator.domain;

public class Calculator {
	private String[] values;

	public Calculator(String[] values) {
		this.values = values;
	}

	public double calculate() {
		double result = Double.parseDouble(values[0]);

		for (int i = 1; i < values.length - 1; i += 2) {
			result = Operator.getOperator(values[i]).operate(result, Double.parseDouble(values[i+1]));
		}
		return result;
	}
}
