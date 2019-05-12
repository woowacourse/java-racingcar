package calculator.domain;

public enum Operator {
	ADDITION("+"), SUBTRACTION("-"), MULTIPLICATION("*"), DIVISION("/");

	private final String operator;

	Operator(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return this.operator;
	}

	public static Operator getOperator(String s) {
		for (Operator o : Operator.values()) {
			if (o.getOperator().equals(s)) {
				return o;
			}
		}
		return null;
	}
}
