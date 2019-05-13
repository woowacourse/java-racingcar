package calculator.domain;

import java.util.function.BiFunction;

public enum Operator {
	ADDITION("+", (num1, num2) -> num1 + num2),
	SUBTRACTION("-", (num1, num2) -> num1 - num2),
	MULTIPLICATION("*", (num1, num2) -> num1 * num2),
	DIVISION("/", (num1, num2) -> num1 / num2);

	private final String operator;
	public BiFunction<Double, Double, Double> calculation;

	Operator(String operator, BiFunction<Double, Double, Double> calculation) {
		this.operator = operator;
		this.calculation = calculation;
	}

	public static Operator getOperator(String operator) {
		for (Operator o : Operator.values()) {
			if (o.getOperator().equals(operator)) {
				return o;
			}
		}
		throw new IllegalArgumentException();
	}

	private String getOperator() {
		return this.operator;
	}

	public double operate(double num1, double num2) {
		return calculation.apply(num1, num2);
	}



}
