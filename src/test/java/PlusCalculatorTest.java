import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlusCalculatorTest {
	@Test
	void plusTwoNumberSplitByComma() {
		final String value = "1,2";
		final int actual = PlusCalculator.calculate(value);
		final int expected = 3;
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void plusTwoNumberSplitByColon() {
		final String value = "1:2";
		final int actual = PlusCalculator.calculate(value);
		final int expected = 3;
		assertThat(actual).isEqualTo(expected);
	}
}
