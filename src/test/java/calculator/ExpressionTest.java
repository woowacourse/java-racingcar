package calculator;

import java.util.ArrayList;
import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.domain.Expression;
import calculator.domain.Operand;

/**
 *
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @since 2020/02/12
 */
public class ExpressionTest {

	@Test
	@DisplayName("연산 테스트")
	void calculate() {
		Expression expression = Expression.valueOf(Arrays.asList(1, 2, 3));
		Assertions.assertThat(expression.calculate())
				.isEqualTo(new Operand(6));
	}

	@Test
	@DisplayName("연산 오버플로우 테스트")
	void calculate_연산_중에_오버플로우가_발생하는_경우() {
		Expression expression = Expression.valueOf(Arrays.asList(Integer.MAX_VALUE, 1));
		Assertions.assertThatThrownBy(() -> expression.calculate())
				.isInstanceOf(ArithmeticException.class);
	}

	@Test
	@DisplayName("연산의 입력값으로 null 리스트가 주어진 경우")
	void calculate_연산의_입력값으로_null이_주어진_경우() {
		Expression expression = new Expression(null);
		Assertions.assertThat(expression.calculate())
				.isEqualTo(new Operand(0));
	}

	@Test
	@DisplayName("연산의 입력값으로 길이가 0인 리스트가 주어진 경우")
	void calculate_연산의_입력값으로_길이가_0인_리스트가_주어진_경우() {
		Expression expression = new Expression(new ArrayList<>());
		Assertions.assertThat(expression.calculate())
				.isEqualTo(new Operand(0));
	}
}
