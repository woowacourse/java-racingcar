package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.domain.Operand;
import calculator.domain.OperandException;

public class OperandTest {
	private Operand operand;

	@Test
	@DisplayName("valueOf 테스트")
	void valueOfTest() {
		Assertions.assertThat(operand.valueOf("3")).isEqualTo(new Operand(3));
	}

	@Test
	@DisplayName("피연산자로 문자가 온 경우")
	void notNumberTest() {
		Assertions.assertThatThrownBy(
			() -> operand.valueOf("a")
		).isInstanceOf(OperandException.class);
	}

	@Test
	@DisplayName("피연산자로 음수가 온 경우")
	void negativeTest() {
		Assertions.assertThatThrownBy(
			() -> operand.valueOf("-1")
		).isInstanceOf(OperandException.class);
	}

	@Test
	@DisplayName("sum 테스트")
	void sumTest() {
		operand = new Operand(1);
		Assertions.assertThat(operand.sum(new Operand(3)))
			.isEqualTo(new Operand(4));
	}
}
