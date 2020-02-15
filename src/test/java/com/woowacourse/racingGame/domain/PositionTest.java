package com.woowacourse.racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class PositionTest {
	public static final int MOVING_UNIT = 1;

	@Test
	void checkValid_위치가_음수() {
		final int negativeNumber = -1;

		assertThatThrownBy(() -> Position.valueOf(negativeNumber))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void increaseByMovingUnit_위치가_Moving_Unit만큼_증가() {
		int initPosition = 4;
		Position position = Position.valueOf(initPosition);
		position = position.increaseByMovingUnit();

		final int actual = position.getPosition();

		final int expected = initPosition + MOVING_UNIT;

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void valueOf_캐싱된_위치() {
		Position position1 = Position.valueOf(1);
		Position position2 = Position.valueOf(1);

		assertThat(position1).isEqualTo(position2);
	}

	@Test
	void valueOf_캐싱되지_못한_위치() {
		Position position1 = Position.valueOf(300);
		Position position2 = Position.valueOf(300);

		assertThat(position1).isNotEqualTo(position2);
	}
}
