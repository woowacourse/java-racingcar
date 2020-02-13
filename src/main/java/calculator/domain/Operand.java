package calculator.domain;

import java.util.Objects;

/**
 * 피연산자 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/12
 */
public class Operand {
	public static final int MIN_NUMBER = 0;
	public static final String INVALID_INPUT_MESSAGE = "올바른 입력이 아닙니다.";
	public static final String LESS_THAN_MIN_MESSAGE = "0보다 크거나 같은 수가 들어와야 합니다.";
	private final int number;

	public Operand(final int number) {
		validateNumber(number);
		this.number = number;
	}

	public static Operand valueOf(final String input) {
		try {
			return new Operand(Integer.parseInt(input));
		} catch (NumberFormatException e) {
			throw new RuntimeException(INVALID_INPUT_MESSAGE);
		}
	}

	private void validateNumber(final int number) {
		if (number < MIN_NUMBER) {
			throw new RuntimeException(LESS_THAN_MIN_MESSAGE);
		}
	}

	public Operand sum(final Operand that) {
		return new Operand(Math.addExact(this.number, that.number));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Operand operand = (Operand)o;
		return number == operand.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	public int getNumber() {
		return number;
	}
}
