package calculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorTest {

	private Calculator calculator;

	@BeforeEach
	void init() {
		calculator = new Calculator(new Separator());
	}

	private void calculatorExceptionText(String inputValue) {
		assertThrows(RuntimeException.class, () -> calculator.splitAndSum(inputValue));
	}

	@ParameterizedTest
	@ValueSource(strings = {"a", "1,a"})
	void 숫자이외의값입력시_예외발생(String inputValue) {
		calculatorExceptionText(inputValue);
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "1,-1"})
	void 음수입력시_예외발생(String inputValue) {
		calculatorExceptionText(inputValue);
	}

	private void calculatorSumTest(String inputValue, int expected) {
		int result = calculator.splitAndSum(inputValue);
		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@NullAndEmptySource
	void null_또는_empty_입력테스트(String inputValue) {
		calculatorSumTest(inputValue, 0);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2=3", "1,2:3=6"}, delimiter = '=')
	void 구분자_작동테스트(String inputValue, String expected) {
		calculatorSumTest(inputValue, Integer.parseInt(expected));
	}

	@ParameterizedTest
	@MethodSource("provideCustomValues")
	void 커스텀구분자_작동테스트(String inputValue, int expected) {
		calculatorSumTest(inputValue, expected);
	}

	private static Stream<Arguments> provideCustomValues() {
		return Stream.of(
				Arguments.of("//;\n1;2;3", 6),
				Arguments.of("//;\n1,2;3", 6),
				Arguments.of("//;\n1;2;3,4:1", 11)
		);
	}

}
