package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	StringCalculator calculator = new StringCalculator();

	@Test
	public void 빈문자열_0반환() {
		assertThat(calculator.calculate("")).isEqualTo(0);
	}

	@Test
	public void 널_0반환() {
		assertThat(calculator.calculate(null)).isEqualTo(0);
	}
}
