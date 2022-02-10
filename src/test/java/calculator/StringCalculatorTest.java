package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	@Test
	public void addTest() {
		int result = StringCalculator.add("1,2");
		assertThat(result).isEqualTo(3);
	}

	@Test
	public void oneNumberTest() {
		int result =StringCalculator.add("1");
		assertThat(result).isEqualTo(1);
	}


}
