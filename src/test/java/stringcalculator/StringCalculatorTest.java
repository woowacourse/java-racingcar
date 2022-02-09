package stringcalculator;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
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
}
