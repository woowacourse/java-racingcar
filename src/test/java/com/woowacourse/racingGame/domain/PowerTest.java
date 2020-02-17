package com.woowacourse.racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class PowerTest {
	@ParameterizedTest
	@CsvSource(value = {"-1", "10"})
	void RandomNo_유효한_범위밖(final int invalidValue) {
		assertThatThrownBy(() -> Power.valueOf(invalidValue))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("유효하지 않은 랜덤 숫자입니다.");
	}

	@Test
	void isMovable_이동_가능() {
		final int movableNumber = 4;
		Power power = Power.valueOf(movableNumber);

		assertThat(power.isMovable()).isTrue();
	}

	@Test
	void isMovable_이동_불가능() {
		final int immovableNumber = 3;
		Power power = Power.valueOf(immovableNumber);

		assertThat(power.isMovable()).isFalse();
	}

	@Test
	void valueOf_캐싱된_범위() {
		final Power power1 = Power.valueOf(3);
		final Power power2 = Power.valueOf(3);

		assertThat(power1).isEqualTo(power2);
	}
}
