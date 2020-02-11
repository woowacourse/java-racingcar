import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
	@Test
	void calculate_null_또는_빈문자() {
		String value = null;
		assertThat(StringAddCalculator.calculate(value)).isEqualTo(0);

		value = "";
		assertThat(StringAddCalculator.calculate(value)).isEqualTo(0);
	}
}
