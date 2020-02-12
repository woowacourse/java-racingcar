package stringCalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	@Test
	void calculate_null_또는_빈문자() {
		String value = null;
		assertThat(StringCalculator.calculate(value)).isEqualTo(0);

		value = "";
		assertThat(StringCalculator.calculate(value)).isEqualTo(0);
	}

	@Test
	void calculate_쉼표_콜론_구분자로_숫자합_계산() {
		String value = "1,2";
		assertThat(StringCalculator.calculate(value)).isEqualTo(3);

		value = "1:2";
		assertThat(StringCalculator.calculate(value)).isEqualTo(3);

		value = "1,2:3";
		assertThat(StringCalculator.calculate(value)).isEqualTo(6);
	}

	@Test
	void calculate_커스텀_구분자로_숫자합_계산() {
		String value = "//;\n1;2;3";
		assertThat(StringCalculator.calculate(value)).isEqualTo(6);
	}

	@Test
	void calculate_숫자_이외의_값() {
		final String invalidValue = "1:2,a";
		assertThatThrownBy(() -> StringCalculator.calculate(invalidValue))
			.isInstanceOf(RuntimeException.class);

		final String invalidValue2 = "//;\n1;2;a";
		assertThatThrownBy(() -> StringCalculator.calculate(invalidValue2))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void calculate_음수() {
		final String invalidValue = "1:2,-2";
		assertThatThrownBy(() -> StringCalculator.calculate(invalidValue))
			.isInstanceOf(RuntimeException.class);

		final String invalidValue2 = "//;\n1;2;-2";
		assertThatThrownBy(() -> StringCalculator.calculate(invalidValue2))
			.isInstanceOf(RuntimeException.class);
	}
}
