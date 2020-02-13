package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.domain.Operand;

/**
 *
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @since 2020/02/12
 */
public class OperandTest {
	@Test
	@DisplayName("생성자 테스트")
	void constructor() {
		Assertions.assertThat(new Operand(3))
				.isInstanceOf(Operand.class);
	}

	@Test
	@DisplayName("생성자에 음수가 입력된 경우")
	void constructor_음수가_입력된_경우() {
		Assertions.assertThatThrownBy(() -> new Operand(-1))
				.isInstanceOf(RuntimeException.class)
				.hasMessageContaining("0보다 크거나 같은 수가 들어와야 합니다.");
	}

	@Test
	@DisplayName("valueOf 테스트")
	void valueOf() {
		String input = "1234";
		Assertions.assertThat(Operand.valueOf(input))
				.isInstanceOf(Operand.class);
	}

	@Test
	@DisplayName("valueOf에 잘못된 입력이 주어진 경우")
	void valueOf_잘못된_입력이_주어진_경우() {
		Assertions.assertThatThrownBy(() -> Operand.valueOf("1b:2:3"))
				.isInstanceOf(RuntimeException.class)
				.hasMessage("올바른 입력이 아닙니다.");
	}

	@Test
	@DisplayName("sum 테스트")
	void sum() {
		Operand firstOperand = new Operand(1);
		Operand secondOperand = new Operand(2);
		Assertions.assertThat(firstOperand.sum(secondOperand)).isEqualTo(new Operand(3));
	}
}
