package stringcalculator;

import static org.assertj.core.api.Assertions.*;
import static stringcalculator.StringCalculatorValidator.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

	@Test
	@DisplayName("null 입력시 0을 반환")
	public void inputNull() {
		// given
		final int actual = StringCalculator.splitAndSum(null);
		// when & then
		assertThat(actual).isEqualTo(0);
	}

	@Test
	@DisplayName("공백 입력시 0 반환")
	public void inputEmpty() {
		// given
		final int actual = StringCalculator.splitAndSum("");
		// when & then
		assertThat(actual).isEqualTo(0);
	}

	@Test
	@DisplayName("숫자 하나")
	public void 숫자_하나() {
		// given
		final int result = StringCalculator.splitAndSum("1");
		// then
		assertThat(result).isEqualTo(1);
	}

	@Test
	@DisplayName("쉼표 구분자")
	public void splitCommaSeparator() {
		// given
		final int actual = StringCalculator.splitAndSum("1,2,3");
		// then
		assertThat(actual).isEqualTo(6);
	}

	@Test
	@DisplayName("쉼표 또는 콜론 구분자")
	public void splitCommaOrColon() {
		// given
		final int actual = StringCalculator.splitAndSum("1,2;3");
		// then
		assertThat(actual).isEqualTo(6);
	}

	@ParameterizedTest
	@ValueSource(strings = {"//;\n1;2;3", "//-\n1-2-3"})
	@DisplayName("커스텀 구분자")
	public void splitCustomDeliminator() {
		// given
		final int actual = StringCalculator.splitAndSum("//;\n1;2;3");
		// then
		assertThat(actual).isEqualTo(6);
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "A", "가"})
	@DisplayName("예외 처리 : 음수, 숫자 이외의 입력")
	public void exception(String input) {
		// then
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> StringCalculator.splitAndSum(input))
			.withMessage(INVALID_NUMBER);
	}
}
