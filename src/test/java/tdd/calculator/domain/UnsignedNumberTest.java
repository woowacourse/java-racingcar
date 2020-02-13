package tdd.calculator.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UnsignedNumberTest {
	@Test
	@DisplayName("UnsignedNumber를 음수로 생성할 때 예외 발생 테스트")
	void testNegative() {
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
			new UnsignedNumber("-1");
		}).withMessage("음수를 입력할 수 없습니다.");
	}

	@Test
	@DisplayName("UnsignedNumber를 숫자 이외의 값으로 생성할 때 예외 발생 테스트")
	void testNotNumber() {
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
			new UnsignedNumber("a");
		});
	}

	@Test
	void getValue() {
		final UnsignedNumber one = new UnsignedNumber("1");
		final int expected = 1;
		final int actual = one.getValue();
		assertEquals(expected, actual);
	}
}