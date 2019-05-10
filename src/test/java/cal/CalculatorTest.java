package cal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/* junit은 한계가 있어서 현장에서 assertj 를 많이 사용한다. */
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
	Calculator cal;
	void 유효하지않은값() {
		assertThrows();
	}

	@Test
	void name() {
	}

	@BeforeEach
	void setUp() {
		cal = new Calculator();
		System.out.println("Setup");
	}

	@Test
	void 덧셈() {
		assertThat(cal.plus(2, 3)).isEqualTo(5);
		System.out.println("plus");
	}

	@Test
	void 뺄셈() {
		assertThat(cal.minus(3, 5)).isEqualTo(-2);
		System.out.println("minus");
	}

	@AfterEach
	void tearDown() {
		cal = null;
		System.out.println("tearDown");
	}
}