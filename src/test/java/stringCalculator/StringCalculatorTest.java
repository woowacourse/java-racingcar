package stringCalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCalculatorTest {
	@Test
	void calculate_null_또는_빈문자() {
		final String nullValue = null;

		assertThat(StringCalculator.calculate(nullValue)).isEqualTo(0);

		final String emptyValue = "";

		assertThat(StringCalculator.calculate(emptyValue)).isEqualTo(0);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2|3", "1:2|3", "1,2:3|6"}, delimiter = '|')
	void calculate_쉼표_콜론_구분자로_숫자합_계산(final String value, final int expected) {
		final int actual = StringCalculator.calculate(value);

		assertThat(actual).isEqualTo(expected);
	}

	// NOTE : @CsvSource로 value들을 넘기려고 할 때 \ 문자를 어떻게 넘길 수 있을까?
	@Test
	void calculate_커스텀_구분자로_숫자합_계산() {
		final String value = "//;\n1;2;3";

		final int actual = StringCalculator.calculate(value);

		final int expected = 6;

		assertThat(actual).isEqualTo(expected);
	}

	// NOTE : 위의 @CsvSource와 같은 고민
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
