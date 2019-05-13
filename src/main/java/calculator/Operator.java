package calculator;

import java.util.Arrays;

public enum Operator {

	ADD("+") {
		@Override
		public int calculate(int a, int b) {
			return a + b;
		}
	},
	SUBTRACT("-") {
		@Override
		public int calculate(int a, int b) {
			return a - b;
		}
	},
	MULTIPLY("*") {
		@Override
		public int calculate(int a, int b) {
			return a * b;
		}
	},
	DIVIDE("/") {
		@Override
		public int calculate(int a, int b) {
			return a / b;
		}
	};

	private String symbol;

	private Operator(String symbol) {
		this.symbol = symbol;
	}

	abstract int calculate(int a, int b);

	public static Operator findOperator(String symbol) {
		return Arrays.stream(Operator.values()).filter(operator -> operator.matchSymbol(symbol)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("올바른 연산자를 입력해주세요. 입력 : " + symbol));
	}

	private boolean matchSymbol(String symbol) {
		return this.symbol.equals(symbol);
	}
}
