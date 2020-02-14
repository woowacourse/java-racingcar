package tdd.calculator.domain;

import static org.assertj.core.api.Assertions.*;

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
		}).withMessage("숫자 이외의 값을 입력할 수 없습니다.");
	}

	@Test
	void getValue() {
		UnsignedNumber one = new UnsignedNumber("1");
		assertThat(one.getValue()).isEqualTo(1);
	}
}