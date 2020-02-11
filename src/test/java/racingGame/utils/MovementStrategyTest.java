package racingGame.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MovementStrategyTest {
	@Test
	void isMovementStrategy_랜덤_값이_3_이하() {
		final int stoppedRandomNumber = 3;
		assertThat(MovementStrategy.isMovementStrategy(stoppedRandomNumber)).isFalse();
	}

	@Test
	void isMovementStrategy_랜덤_값이_4_이상() {
		final int movedRandomNumber = 5;
		assertThat(MovementStrategy.isMovementStrategy(movedRandomNumber)).isTrue();
	}
}
