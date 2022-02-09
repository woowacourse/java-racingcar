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

	@Test
	public void 숫자_두개를_콜론_구분후_합을_반환() {
		assertThat(calculator.calculate("1:2")).isEqualTo(3);
	}

	@Test
	public void 여러개의_숫자를_구분자로_구분후_합을_반환() {
		assertThat(calculator.calculate("1:2,3:4,5")).isEqualTo(15);
	}

	@Test
	public void 커스텀_구분자를_지정후_합을_반환() {
		assertThat(calculator.calculate("//;\n1;2;3")).isEqualTo(6);
	}

	@Test
	public void 음수를_전달할_경우_예외_발생() {
		assertThatThrownBy(() -> calculator.calculate("-1,2,3"))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
