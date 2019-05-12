package calculator.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Operator {

	PLUS("+") {
		public int calculate(int first, int second) {
			return (first + second);
		}
	},
	MINUS("-") {
		public int calculate(int first, int second) {
			return (first - second);
		}
	},
	MULTIPLICATION("*") {
		public int calculate(int first, int second) {
			return (first * second);
		}
	},
	DIVISION("/") {
		public int calculate(int first, int second) {
			try {
				return (first / second);
			} catch (ArithmeticException e) {
				throw new IllegalArgumentException("0으로 나눌 수 없습니다");
			}
		}
	};

	private final String symbol;

	private Operator(String symbol) {
		this.symbol = symbol;
	}

	private static final Map<String, Operator> stringToEnum = new HashMap<>();

	static {
		for (Operator operator : values()) {
			stringToEnum.put(operator.symbol, operator);
		}
	}

	public String getSymbol() {
		return this.symbol;
	}

	public static Operator fromSymbol(String symbol) {
		if (stringToEnum.containsKey(symbol))
			return stringToEnum.get(symbol);

		throw new IllegalArgumentException("+, -, *, / 를 연산자로 입력해주세요");
	}

	abstract public int calculate(int first, int second);
}
