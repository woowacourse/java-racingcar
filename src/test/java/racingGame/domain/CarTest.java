package racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
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
}
