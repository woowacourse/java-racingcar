package calculator;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.domain.Expression;
import calculator.domain.ExpressionException;
import calculator.domain.Operand;

public class ExpressionTest {
	private Expression expression;
	private List<Operand> operands;

	@BeforeEach
	void setUp() {
		operands = new ArrayList<>();
	}

	@Test
	@DisplayName("Expression(Operand 리스트)이 null인 경우")
	void nullTest() {
		expression = new Expression(null);
		Assertions.assertThat(expression.calculate()).isEqualTo(new Operand(0));
	}

	@Test
	@DisplayName("Expression(Operand 리스트)이 길이가 0인 경우")
	void emptyTest() {
		expression = new Expression(null);
		Assertions.assertThat(expression.calculate()).isEqualTo(new Operand(0));
	}

	@Test
	@DisplayName("Expression(Operand 리스트)의 피연산자가 1개인 경우")
	void singleNumberTest() {
		operands.add(new Operand(1));
		expression = new Expression(operands);

		Assertions.assertThat(expression.calculate()).isEqualTo(new Operand(1));
	}

	@Test
	@DisplayName("연산의 결과가 오버플로우된 경우")
	void overflowTest() {
		operands.add(new Operand(Integer.MAX_VALUE));
		operands.add(new Operand(1));
		expression = new Expression(operands);

		Assertions.assertThatThrownBy(
			() -> expression.calculate()
		).hasMessage(ExpressionException.INTEGER_OVERFLOW);
	}
}
