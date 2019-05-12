package calculator.domain;

public enum Operator {
	ADDITION("+"), SUBTRACTION("-"), MULTIPLICATION("*"), DIVISION("/");

	private static final Operator[] operators = Operator.values();
	private final String operator;

	Operator(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return this.operator;
	}

	public static Operator of(String s) {
		for (Operator o : operators) {
			if (o.getOperator().equals(s)) {
				return o;
			}
		}
		return null;
	}
}
