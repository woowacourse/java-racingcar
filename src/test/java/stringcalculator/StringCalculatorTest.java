package stringcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {
	StringCalculator calculator = new StringCalculator();

	@Test
	void 빈문자() {
		String input = "";
		int actual = calculator.splitAndSum(input);
		assertThat(actual).isEqualTo(0);
	}

	@Test
	void null_판정() {
		String input = null;
		int actual = calculator.splitAndSum(input);
		assertThat(actual).isEqualTo(0);
	}

	@Test
	void 숫자_하나_입력() {
		String input = "1";
		int actual = calculator.splitAndSum(input);
		int expected = 1;
		assertThat(actual).isEqualTo(expected);
	}

	@ParameterizedTest
	@ValueSource(strings = {"&&&", "1,&,2", "//+\n1++3"})
	void 숫자_이외의_값(String input) {
		assertThatThrownBy(() -> {
			calculator.splitAndSum(input);
		}).isInstanceOf(RuntimeException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "-1,1,2", "//+\n1+-1+3"})
	void 음수_입력(String input) {
		assertThatThrownBy(() -> {
			calculator.splitAndSum(input);
		}).isInstanceOf(RuntimeException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1,2:3","//+\n1+2+3"})
	void SplitAndSum(String input) {
		int expected = 6;
		assertThat(calculator.splitAndSum(input)).isEqualTo(expected);
	}
}
