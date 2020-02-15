package com.woowacourse.racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class CarTest {
	private static final int MOVING_UNIT = 1;

	@Test
	void attemptMoveThrough_범위_밖의_수() {
		final int lowerNumber = -1;
		final Car car = new Car(new Name("test"), Position.valueOf(4));

		assertThatThrownBy(() -> car.attemptMoveThrough(RandomNo.valueOf(lowerNumber)))
			.isInstanceOf(IllegalArgumentException.class);

		final int higherNumber = 10;
		final Car car1 = new Car(new Name("test"), Position.valueOf(4));

		assertThatThrownBy(() -> car1.attemptMoveThrough(RandomNo.valueOf(higherNumber)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void attemptMoveThrough_랜덤_값이_3_이하() {
		final int stoppedRandomNumber = 3;
		final Car car = new Car(new Name("test"), Position.valueOf(4));
		car.attemptMoveThrough(RandomNo.valueOf(stoppedRandomNumber));

		final int actual = car.getPosition();

		final int expected = 4;

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void attemptMoveThrough_랜덤_값이_4_이상() {
		final int movedRandomNumber = 7;
		final Car car = new Car(new Name("test"), Position.valueOf(4));
		car.attemptMoveThrough(RandomNo.valueOf(movedRandomNumber));

		final int actual = car.getPosition();

		final int expected = 4 + MOVING_UNIT;

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void isSamePosition_우승한_위치의_자동차() {
		final int winnerPosition = 7;
		final Car car = new Car(new Name("test"), Position.valueOf(7));

		assertThat(car.isSamePosition(winnerPosition)).isTrue();
	}

	@Test
	void isSamePosition_우승하지_못한_위치의_자동차() {
		final int winnerPosition = 7;
		final Car car = new Car(new Name("test"), Position.valueOf(6));

		assertThat(car.isSamePosition(winnerPosition)).isFalse();
	}
}
