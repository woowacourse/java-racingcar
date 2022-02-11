package stringcalculator;

import static org.assertj.core.api.Assertions.*;
import static stringcalculator.StringCalculatorValidator.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

	@Test
	@DisplayName("#1 null 혹은 빈 문자")
	public void nullOrEmpty() {
		// given
		int caseNull = StringCalculator.splitAndSum(null);
		int caseEmpty = StringCalculator.splitAndSum("");

		// then
		assertThat(caseNull).isEqualTo(0);
		assertThat(caseEmpty).isEqualTo(0);
	}

	@Test
	@DisplayName("#2 숫자 하나")
	public void 숫자_하나() {
		// given
		int result = StringCalculator.splitAndSum("1");

		// then
		int expected = 1;
		assertThat(result).isEqualTo(expected);

	}

	@Test
	@DisplayName("#3 쉼표 구분자")
	public void splitCommaSeparator() {
		// given
		int result = StringCalculator.splitAndSum("1,2,3");

		// then
		assertThat(result).isEqualTo(6);
	}

	@Test
	@DisplayName("#4 쉼표 또는 콜론 구분자")
	public void splitCommaOrColon() {
		// given
		int result = StringCalculator.splitAndSum("1,2;3");

		// then
		assertThat(result).isEqualTo(6);
	}

	@Test
	@DisplayName("#5 커스텀 구분자")
	public void splitCustomDeliminator() {
		// given
		int result = StringCalculator.splitAndSum("//;\n1;2;3");

		// then
		assertThat(result).isEqualTo(6);
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "A", "가"})
	@DisplayName("#6 예외 처리 : 음수, 숫자 이외의 입력")
	public void exception(String input) {
		// then
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> StringCalculator.splitAndSum(input))
			.withMessage(INVALID_NUMBER);
	}
}
