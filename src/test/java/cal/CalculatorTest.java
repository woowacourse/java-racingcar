/*
 * @(#)CalculatorTest.java      1.0 2019/05/12
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */
package cal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @version 1.0 2019년 05년 12일
 * @author 김효건
 */
class CalculatorTest {
	/*계산기 로직을 테스팅하는 클래스*/
	Calculator cal;

	@BeforeEach
	void setUp() {
		cal = new Calculator();
	}

	@Test
	void 항의개수_3미만_검사() {
		assertThrows(IllegalArgumentException.class, ()->{
			cal.execute("3+");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			cal.execute("*3");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			cal.execute("3 +");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			cal.execute("/ 3");
		});
	}

	@Test
	void 항의개수_홀수_검사() {
		assertThrows(IllegalArgumentException.class, ()->{
			cal.execute("3 * 5 +");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			cal.execute("3 * 5 + 7 *");
		});
	}

	@Test
	void 정수입력위치_오류() {
		assertThrows(NumberFormatException.class, ()->{
			cal.execute("+ 3 * 7");
		});
		assertThrows(NumberFormatException.class, ()->{
			cal.execute("3 * +");
		});
		assertThrows(NumberFormatException.class, ()->{
			cal.execute("! * 3");
		});
		assertThrows(NumberFormatException.class, ()->{
			cal.execute("a - 3");
		});
	}

	@Test
	void 연산자입력위치_오류() {
		assertThrows(IllegalArgumentException.class, ()->{
			cal.execute("3 5");
		});
		assertThrows(IllegalArgumentException.class, ()->{
			cal.execute("3 ! 5");
		});

		assertThrows(IllegalArgumentException.class, ()->{
			cal.execute("3 + 5 a 6");
		});
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
	}
}