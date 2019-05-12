package calculator.domain;

public enum Operator {
	ADDITION("+") {
		double operate(double num1, double num2) {
			return num1 + num2;
		}
	},
	SUBTRACTION("-") {
		double operate(double num1, double num2) {
			return num1 - num2;
		}
	},
	MULTIPLICATION("*") {
		double operate(double num1, double num2) {
			return num1 * num2;
		}
	},
	DIVISION("/") {
		double operate(double num1, double num2) {
			return num1 / num2;
		}
	};

	private final String operator;

	Operator(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return this.operator;
	}

	abstract double operate(double num1, double num2);

	public static Operator getOperator(String s) {
		for (Operator o : Operator.values()) {
			if (o.getOperator().equals(s)) {
				return o;
			}
		}
		return null;
	}
}
