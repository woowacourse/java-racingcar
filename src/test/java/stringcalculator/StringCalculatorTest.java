package stringcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	StringCalculator calculator = new StringCalculator();

	@Test
	void 쉼표_구분자() {
		String[] expected = {"1", "2"};
		assertThat(calculator.split("1,2")).isEqualTo(expected);
	}

	@Test
	void 콜론_구분자() {
		String[] expected = {"1", "2"};
		assertThat(calculator.split("1:2")).isEqualTo(expected);
	}

	@Test
	void 커스텀_구분자() {
		// java.util.regex 패키지의 Matcher, Pattern import
		String input = "//+\n1+2+3"; // 예약어인 +, *, ^ 는 그냥 쓸 경우 오류
		String input2 = "//;\n1;2;3";

		String[] actual = calculator.customDelimiter(input);
		String[] actual2 = calculator.customDelimiter(input2);

		String[] expected = {"1", "2", "3"};
		assertThat(actual).isEqualTo(0);
		assertThat(actual2).isEqualTo(expected);
	}
}
