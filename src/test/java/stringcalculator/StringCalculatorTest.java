package stringcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {
	StringCalculator calculator = new StringCalculator();

	@Test
	@DisplayName("빈 문자열 입력시 0 반환")
	void emptyInputTest() {
		String input = "";
		int actual = calculator.splitAndSum(input);
		assertThat(actual).isEqualTo(0);
	}

	@Test
	@DisplayName("null 입력시 0 반환")
	void nullInputTest() {
		String input = null;
		int actual = calculator.splitAndSum(input);
		assertThat(actual).isEqualTo(0);
	}

	@Test
	@DisplayName("숫자 하나 입력시 그대로 반환")
	void oneNumberInputTest() {
		String input = "1";
		int actual = calculator.splitAndSum(input);
		int expected = 1;
		assertThat(actual).isEqualTo(expected);
	}

	@ParameterizedTest
	@ValueSource(strings = {"&&&", "1,&,2", "//+\n1++3"})
	@DisplayName("숫자 이외의 값 입력시 예외 발생")
	void numberFormatExceptionTest(String input) {
		assertThatThrownBy(() -> {
			calculator.splitAndSum(input);
		}).isInstanceOf(RuntimeException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "-1,1,2", "//+\n1+-1+3"})
	@DisplayName("음수 입력시 예외 발생")
	void negativeInputTest(String input) {
		assertThatThrownBy(() -> {
			calculator.splitAndSum(input);
		}).isInstanceOf(RuntimeException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2:3", "//+\n1+2+3"})
	@DisplayName("합 기능 테스트")
	void splitAndSumTest(String input) {
		int expected = 6;
		assertThat(calculator.splitAndSum(input)).isEqualTo(expected);
	}
}
