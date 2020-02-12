package racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
	private static final int MOVING_UNIT = 1;

	private Car car;

	@BeforeEach
	void init() {
		final String name = "test";

		car = new Car(new Name(name));
	}

	@Test
	void move_랜덤_값이_3_이하() {
		final int stoppedRandomNumber = 3;
		final int initPosition = car.getPosition();

		car.move(stoppedRandomNumber);
		final int actual = car.getPosition();

		final int expected = initPosition;

		System.out.println(car.toString());

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void move_랜덤_값이_4_이상() {
		final int movedRandomNumber = 7;
		final int initPosition = car.getPosition();

		car.move(movedRandomNumber);
		final int actual = car.getPosition();

		final int expected = initPosition + MOVING_UNIT;

		assertThat(actual).isEqualTo(expected);
	}
}
