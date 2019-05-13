package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
	StringCalculator stringCalculator;

	@BeforeEach
	void setup() {
		stringCalculator = new StringCalculator();
	}

	@Test
	void 계산() {
		int result;

		result = calculate("2 + 3 * 4 / 2");
		assertThat(result).isEqualTo(10);

		result = calculate("3 + 7 / 2 * 5");
		assertThat(result).isEqualTo(25);

		result = calculate("100 / 4 * 3 + 3");
		assertThat(result).isEqualTo(78);

		result = calculate("9 - 7 * 1 - 2");
		assertThat(result).isEqualTo(0);
	}

	int calculate(String formula) {
		String[] arr = formula.split(" ");
		return stringCalculator.calculate(arr);
	}
}
