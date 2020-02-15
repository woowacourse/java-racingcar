package com.woowacourse.racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class PositionTest {
	public static final int MOVING_UNIT = 1;

	@Test
	void checkValid_위치가_음수() {
		final int negativeNumber = -1;

		assertThatThrownBy(() -> new Position(negativeNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void increaseByMovingUnit_위치가_Moving_Unit만큼_증가() {
		int initPosition = 4;
		Position position = new Position(initPosition);
		position = position.increaseByMovingUnit();

		final int actual = position.getPosition();

		final int expected = initPosition + MOVING_UNIT;

		assertThat(actual).isEqualTo(expected);
	}
}
