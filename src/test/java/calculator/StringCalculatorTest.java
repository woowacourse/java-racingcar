package calculator;

import calculator.domain.Operand;
import calculator.domain.Operator;
import calculator.domain.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalculatorTest {

	@Test
	public void 덧셈_기능을_테스트한다() {
		assertThat(Operator.PLUS.calculate(2, 3)).isEqualTo(5);
	}

	@Test
	public void 뺄셈_기능을_테스트한다() {
		assertThat(Operator.MINUS.calculate(2, 3)).isEqualTo(-1);
	}

	@Test
	public void 곱셈_기능을_테스트한다() {
		assertThat(Operator.MULTIPLICATION.calculate(2, 3)).isEqualTo(6);
	}

	@Test
	public void 나눗셈_기능을_테스트한다() {
		assertThat(Operator.DIVISION.calculate(2, 3)).isEqualTo(0);
	}

	@Test
	public void 나눗셈_0으로_나눴을때() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			Operator.DIVISION.calculate(1, 0);
		});
	}

	@Test
	public void testValueOf() {
		assertThat(Operator.fromSymbol("+")).isEqualTo(Operator.PLUS);
		assertThat(Operator.fromSymbol("-")).isEqualTo(Operator.MINUS);
		assertThat(Operator.fromSymbol("*")).isEqualTo(Operator.MULTIPLICATION);
		assertThat(Operator.fromSymbol("/")).isEqualTo(Operator.DIVISION);
	}

	@Test
	public void Operand클래스에서_정수외에_다른_문자열로_생성했을때() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Operand("+");
		});
	}

	@Test
	public void Operator클래스에서_연산자외에_다른_기호로_생성했을때() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			Operator.fromSymbol("!");
		});
	}

	@Test
	public void NULL을_기호로_입력했을때() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			Operator.fromSymbol(null);
		});
	}

	@Test
	public void 긴_문자열_수식을_테스트한다() {
		assertThat(StringCalculator.calculate("2 + 3 * 4 / 2 - 7")).isEqualTo(3);
	}

	@Test
	public void 잘못된_수식을_테스트한다() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			StringCalculator.calculate("2 + 3 * a / 2 - 7");
		});

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			StringCalculator.calculate("2 ! 3 * a / 2 - 7");
		});
	}
}