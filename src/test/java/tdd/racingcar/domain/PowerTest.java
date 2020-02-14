package tdd.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PowerTest {
	@Test
	@DisplayName("파워가 0 이상 9 이하가 아닐 때 예외 발생 테스트")
	void textInvalidPower() {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new Power(10));
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> new Power(-1));
	}

	@Test
	void isEnough() {
		Power enoughPower = new Power(4);
		Power notEnoughPower = new Power(3);
		assertThat(enoughPower.isEnough()).isTrue();
		assertThat(notEnoughPower.isEnough()).isFalse();
	}
}
