package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

	private Calculator calculator;

	@BeforeEach
	void init() {
		calculator = new Calculator();
	}

	@Test
	void 정상_작동() {
		String inputValue = "1,2";
		int expected = 3;

		int answer = calculator.splitAndSumNumber(inputValue);
		assertThat(answer).isEqualTo(expected);
	}

	@Test
	void 빈_문자열() {
		String inputValue = "";
		int expected = 0;

		int answer = calculator.splitAndSumNumber(inputValue);
		assertThat(answer).isEqualTo(expected);
	}

	@Test
	void null_입력() {
		String inputValue = null;
		int expected = 0;

		int answer = calculator.splitAndSumNumber(inputValue);
		assertThat(answer).isEqualTo(expected);
	}

	@Test
	void 숫자_이외의_값() {
		String inputValue = "a";
		assertThrows(RuntimeException.class, () -> calculator.splitAndSumNumber(inputValue));
	}

	@Test
	void 음수값() {
		String inputValue = "-1";
		assertThrows(RuntimeException.class, () -> calculator.splitAndSumNumber(inputValue));
	}

	@Test
	void 커스텀_구분자(){
		String inputValue = "//;\n1;2;3";
		int expected = 6;

		int answer = calculator.splitAndSumNumber(inputValue);
		assertThat(answer).isEqualTo(expected);
	}

	@Test
	void 커스텀_구분자_여러개(){
		String inputValue = "//;!\n1;2;3!3";
		int expected = 9;

		int answer = calculator.splitAndSumNumber(inputValue);
		assertThat(answer).isEqualTo(expected);
	}

	@Test
	void 커스텀_구분자와_기존_구분자_혼합(){
		String inputValue = "//;\n1;2;3,3:1";
		int expected = 10;

		int answer = calculator.splitAndSumNumber(inputValue);
		assertThat(answer).isEqualTo(expected);
	}

}
