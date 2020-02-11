package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CalculatorTest {
	@Test
	void 덧셈() {
		int result = Calculator.calculate("1,2");
		assertThat(result).isEqualTo(3);

		result = Calculator.calculate("1:5");
		assertThat(result).isEqualTo(6);

		result = Calculator.calculate("1:5:7,5,1");
		assertThat(result).isEqualTo(19);

		result = Calculator.calculate("//^\n1:5:7^5,1");
		assertThat(result).isEqualTo(19);
	}
}
