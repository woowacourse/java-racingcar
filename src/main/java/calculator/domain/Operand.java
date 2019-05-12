/*
 * Operand.java
 */
package calculator.domain;

public class Operand {
	private final int number;

	public Operand(String number) {
		try {
			this.number = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("피연산자는 정수만 가능합니다");
		}
	}

	public Operand(int number) {
		this.number = number;
	}

	public int intValue() {
		return this.number;
	}
}
