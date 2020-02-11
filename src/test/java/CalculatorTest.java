import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.Calculator;
import utils.Split;

public class CalculatorTest {

	@ParameterizedTest
	@DisplayName("정상적으로 작동할 경우")
	@CsvSource(value = {"1,2:3 6", "1.0,1.1 2.1"}, delimiter = ' ')
	void addNumbers(String value, Double expected) {
		String[] numbers = Split.splitByCommaOrColon(value);
		Double result = Calculator.calculate(numbers);

		Assertions.assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("비정상적으로 작동할 경우")
	@CsvSource(value = {"1,2:3 0", "1.0,1.1 2.3"}, delimiter = ' ')
	void error_addNumbers(String value, Double expected) {
		String[] numbers = Split.splitByCommaOrColon(value);
		Double result = Calculator.calculate(numbers);

		Assertions.assertThat(result).isNotEqualTo(expected);
	}

	@Test
	@DisplayName("커스텀 delimiter 가 정상적으로 작동할 경우")
	void addNumberByCustomDelimiter() {
		String value1 = "//;\n1;2;3";
		Double expected = 6.0;

		String[] numbers = Split.splitNumberByCustomByDelimiter(value1);
		Double result = Calculator.calculate(numbers);

		Assertions.assertThat(result).isEqualTo(expected);
	}
}
