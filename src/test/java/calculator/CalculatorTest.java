package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class CalculatorTest {

	@Test
	void 덧셈() {
		String input = "1,2:3,4";
		int result = Calculator.calculate(input);
		assertThat(result).isEqualTo(10);
	}

	@Test
	void 숫자아닌값_혹은_음수_입력() {
		String notNumberAndMinusValueInputs = "ㅋㅋ:-222,-2abc";
		assertThatThrownBy(() -> {
			Calculator.calculate(notNumberAndMinusValueInputs);
		}).isInstanceOf(RuntimeException.class);
	}

	@Test
	void 숫자만_들어왔을때() {
		String input = "123";
		int result = Calculator.calculate(input);
		assertThat(result).isEqualTo(123);
	}
}
