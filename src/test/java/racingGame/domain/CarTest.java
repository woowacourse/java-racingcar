package racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
	private static final int MOVING_UNIT = 1;

	private Car car;

	@BeforeEach
	void init() {
		car = new Car();
	}

	@Test
	void isMove_랜덤_값이_3_이하() {
		final int stoppedRandomNumber = 3;

		assertThat(car.isMove(stoppedRandomNumber)).isFalse();
	}

	@Test
	void isMove_랜덤_값이_4_이상() {
		final int movedRandomNumber = 5;

		assertThat(car.isMove(movedRandomNumber)).isTrue();
	}

	@Test
	void move_이동을_해야하는_상태() {
		final int initPosition = car.getPosition();
		final boolean moveStatus = true;

		car.move(moveStatus);
		final int actual = car.getPosition();

		final int expected = initPosition + MOVING_UNIT;

		assertThat(actual).isEqualTo(expected);
	}
}
