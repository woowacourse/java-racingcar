package com.woowacourse.racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class RandomNoTest {
	@Test
	void RandomNo_유효한_범위밖() {
		final int invalidValue1 = -1;

		assertThatThrownBy(() -> new RandomNo(invalidValue1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("유효하지 않은 랜덤 숫자입니다.");

		final int invalidValue2 = 10;

		assertThatThrownBy(() -> new RandomNo(invalidValue2))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("유효하지 않은 랜덤 숫자입니다.");
	}

	@Test
	void isMovable_이동_가능() {
		final int movableNumber = 4;
		RandomNo randomNo = new RandomNo(movableNumber);

		assertThat(randomNo.isMovable()).isTrue();
	}

	@Test
	void isMovable_이동_불가능() {
		final int immovableNumber = 3;
		RandomNo randomNo = new RandomNo(immovableNumber);

		assertThat(randomNo.isMovable()).isFalse();
	}
}
