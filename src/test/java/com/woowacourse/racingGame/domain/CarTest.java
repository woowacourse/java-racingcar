package com.woowacourse.racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {
	private static final int MOVING_UNIT = 1;

	@Test
	void attemptMoveThrough_랜덤_값이_3_이하() {
		final int stoppedRandomNumber = 3;
		final Car car = new Car(new Name("test"), new Position(4));
		car.attemptMoveThrough(stoppedRandomNumber);

		final int actual = car.getPosition();

		final int expected = 4;

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void attemptMoveThrough_랜덤_값이_4_이상() {
		final int movedRandomNumber = 7;
		final Car car = new Car(new Name("test"), new Position(4));
		car.attemptMoveThrough(movedRandomNumber);

		final int actual = car.getPosition();

		final int expected = 4 + MOVING_UNIT;

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void isSamePosition_우승한_위치의_자동차() {
		final int winnerPosition = 7;
		final Car car = new Car(new Name("test"), new Position(7));

		assertThat(car.isSamePosition(winnerPosition)).isTrue();
	}

	@Test
	void isSamePosition_우승하지_못한_위치의_자동차() {
		final int winnerPosition = 7;
		final Car car = new Car(new Name("test"), new Position(6));

		assertThat(car.isSamePosition(winnerPosition)).isFalse();
	}
}
