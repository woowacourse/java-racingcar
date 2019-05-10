package cal;

<<<<<<< HEAD
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
=======
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
	Calculator cal;
>>>>>>> pair-reposit/men7627

	@BeforeEach
	void setUp() {
		cal = new Calculator();
<<<<<<< HEAD
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
=======
	}

	@Test
	void 이항연산() {
		assertThat(cal.execute("5 + 3")).isEqualTo(8);
		assertThat(cal.execute("5 - 3")).isEqualTo(2);
		assertThat(cal.execute("5 * 3")).isEqualTo(15);
		assertThat(cal.execute("6 / 3")).isEqualTo(2);
	}

	@Test
	void 삼항연산() {
		assertThat(cal.execute("5 + 3 / 4")).isEqualTo(2);
		assertThat(cal.execute("5 - 3 * 2")).isEqualTo(4);
		assertThat(cal.execute("5 * 3 * -1")).isEqualTo(-15);
		assertThat(cal.execute("6 / 3 + 5")).isEqualTo(7);
	}

	@Test
	void 사항연산() {
		assertThat(cal.execute("5 + 3 / 4 + 1")).isEqualTo(3);
		assertThat(cal.execute("5 - 3 * 2 - 4")).isEqualTo(0);
		assertThat(cal.execute("5 * 3 * -1 / -5")).isEqualTo(3);
		assertThat(cal.execute("6 / 3 + 5 / 7")).isEqualTo(1);
>>>>>>> pair-reposit/men7627
	}
}