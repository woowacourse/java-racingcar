package calculator;

import calculator.domain.StringCalculator;
import calculator.domain.Operator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalculatorTest {
	StringCalculator stringCalculator;

	@BeforeEach
	public void setUp() {
		stringCalculator = new StringCalculator();
	}

	@Test
	public void 덧셈_기능을_테스트한다() {
		//assertThat(stringCalculator.calculate("2 + 3")).isEqualTo(5);
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
	public void 연산자외에_다른_기호로_생성했을때() {
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
		assertThat(stringCalculator.calculate("2 + 3 * 4 / 2 - 7")).isEqualTo(3);
	}

	@AfterEach
	public void tearDown() {
		stringCalculator = null;
	}
}