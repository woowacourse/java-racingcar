package calculator;

import calculator.domain.StringCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
	StringCalculator stringCalculator;

	@BeforeEach
	public void setUp() {
		stringCalculator = new StringCalculator();
	}

	@Test
	public void 덧셈_기능을_테스트한다() {
		assertThat(stringCalculator.calculate("2 + 3")).isEqualTo(5);
	}

	@Test
	public void 뺄셈_기능을_테스트한다() {
		assertThat(stringCalculator.calculate("2 - 3")).isEqualTo(-1);
	}

	@Test
	public void 곱셈_기능을_테스트한다() {
		assertThat(stringCalculator.calculate("2 * 3")).isEqualTo(6);
	}

	@Test
	public void 나눗셈_기능을_테스트한다() {
		assertThat(stringCalculator.calculate("10 / 3")).isEqualTo(3);
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