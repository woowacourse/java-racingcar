package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
	@Test
	public void add() {
		int result = Calculator.calculate("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void customAdd() {
		int result = Calculator.calculate("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}
}
