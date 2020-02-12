package com.woowacourse.racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PositionTest {
	@Test
	void checkValidation_위치가_음수() {
		final int invalidValue = -1;

		assertThatThrownBy(() -> new Position(invalidValue))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void increaseOne_위치가_1_증가() {
		Position value = Position.ZERO;
		int currentPosition = value.getPosition();
		value = value.increaseOne();

		final int actual = value.getPosition();

		final int expected = currentPosition + 1;

		assertThat(actual).isEqualTo(expected);
	}
}
