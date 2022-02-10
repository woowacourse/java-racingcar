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
		assertThat(actual).isEqualTo(expected);
		assertThat(actual2).isEqualTo(expected);
	}

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

	@Test
	void 합() {
		String[] input = {"1", "2"};
		int actual = calculator.sum(input);
		int expected = 3;
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void 숫자_이외의_값() {
		String input1 = "&&&";
		String input2 = "1,&,2";
		assertThatThrownBy(() -> {
			calculator.splitAndSum(input1);
			calculator.splitAndSum(input2);
		}).isInstanceOf(RuntimeException.class);
	}

	@Test
	void 음수_입력() {
		String input1 = "-1";
		String input2 = "-1,1,2";
		assertThatThrownBy(() -> {
			calculator.splitAndSum(input1);
			calculator.splitAndSum(input2);
		}).isInstanceOf(RuntimeException.class);
	}
}
