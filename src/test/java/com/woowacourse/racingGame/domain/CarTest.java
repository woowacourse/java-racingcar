package com.woowacourse.racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {
	private static final int MOVING_UNIT = 1;

	private MovableStrategy movableStrategy;

	@Test
	void attemptMoveThrough_랜덤_값이_3_이하() {
		final int stoppedRandomNumber = 3;
		movableStrategy = new PlannedMovableStrategy(new Power(stoppedRandomNumber));
		final Car car = new Car(new Name("test"), Position.valueOf(4), movableStrategy);
		car.attemptMoveThrough();

		final int actual = car.getPosition();

		final int expected = 4;

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void attemptMoveThrough_랜덤_값이_4_이상() {
		final int movedRandomNumber = 7;
		final MovableStrategy movableStrategy = new PlannedMovableStrategy(new Power(movedRandomNumber));
		final Car car = new Car(new Name("test"), Position.valueOf(4), movableStrategy);
		car.attemptMoveThrough();

		final int actual = car.getPosition();

		final int expected = 4 + MOVING_UNIT;

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void isSamePosition_우승한_위치의_자동차() {
		final int winnerPosition = 7;
		final MovableStrategy movableStrategy = new RandomMovableStrategy();
		final Car car = new Car(new Name("test"), Position.valueOf(7), movableStrategy);

		assertThat(car.isSamePosition(winnerPosition)).isTrue();
	}

	@Test
	void isSamePosition_우승하지_못한_위치의_자동차() {
		final int winnerPosition = 7;
		final MovableStrategy movableStrategy = new RandomMovableStrategy();
		final Car car = new Car(new Name("test"), Position.valueOf(6), movableStrategy);

		assertThat(car.isSamePosition(winnerPosition)).isFalse();
	}
}
