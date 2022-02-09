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

	@Test
	public void 숫자가_하나_그대로반환() {
		assertThat(calculator.calculate("1")).isEqualTo(1);
	}

	@Test
	public void 숫자_두개를_컴마_구분후_합을_반환() {
		assertThat(calculator.calculate("1,2")).isEqualTo(3);
	}
}
